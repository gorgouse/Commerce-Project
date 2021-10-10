package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.util.StringUtil;
import xmt.item.webapp.dao.OrderDao;
import xmt.item.webapp.dao.ShopcarDao;
import xmt.item.webapp.dao.StoreDao;
import xmt.item.webapp.entity.OrderDatainfo;
import xmt.item.webapp.entity.OrderDetailInfo;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webapp.entity.StoreInfo;

import java.util.stream.Collectors;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private ShopcarDao shopcarDao;
    @Resource
    private StoreDao storeDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class )
    public AppResponse orderAdd(OrderInfo orderInfo){
        //校验付款
        if(orderInfo.getIsPay().equals("1")){//已经付款
            orderInfo.setState("2");
        }
        else {
            orderInfo.setState("1");
        }
        //分割
        List<String> goodsIdList = Arrays.asList(orderInfo.getGoodsIds().split(","));
        List<String> goodsNameList = Arrays.asList(orderInfo.getGoodsNames().split(","));
        List<String> goodsImgList = Arrays.asList(orderInfo.getGoodsImg().split(","));
        List<String> goodsDescList = Arrays.asList(orderInfo.getGoodsDesc().split(","));
        List<String> goodsCountList = Arrays.asList(orderInfo.getGoodsCounts().split(","));
        List<String> goodsPriceList = Arrays.asList(orderInfo.getGoodsPrices().split(","));

        //将商品以店铺归类
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for(int i = 0;i<goodsIdList.size();i++){
            OrderInfo orderInfo1 = new OrderInfo();
            String goodsId = goodsIdList.get(i);
            orderInfo1.setStoreId(storeDao.getStoreIdByGoodsId(goodsId));
            orderInfo1.setGoodsIds(goodsIdList.get(i));
            orderInfo1.setGoodsNames(goodsNameList.get(i));
            orderInfo1.setGoodsImg(goodsImgList.get(i));
            orderInfo1.setGoodsDesc(goodsDescList.get(i));
            orderInfo1.setGoodsCounts(goodsCountList.get(i));
            orderInfo1.setGoodsPrices(goodsPriceList.get(i));
            orderInfoList.add(orderInfo1);
        }
        Map<String,List<OrderInfo>> listMap = orderInfoList.stream().collect(Collectors.groupingBy(OrderInfo::getStoreId));
        for(Map.Entry<String,List<OrderInfo>> entry:listMap.entrySet()){
            //新增主订单
            OrderInfo mainOrder = new OrderInfo();
            mainOrder.setId(StringUtil.getCommonCode(3));
            mainOrder.setUserId(orderInfo.getUserId());
            mainOrder.setAddressId(orderInfo.getAddressId());
            mainOrder.setState(orderInfo.getState());
            mainOrder.setStoreId(entry.getKey());
            Double total = 0.00 ;
            Double price = 0.00;
            for(OrderInfo key : entry.getValue()){
                total = total + Double.valueOf(key.getGoodsCounts());
                price = price + Double.valueOf(key.getGoodsCounts())*Double.valueOf(key.getGoodsPrices());
            }
            mainOrder.setTotalPrice(price.toString());
            mainOrder.setAllCount(total.toString());
            int orderAdd = orderDao.orderAdd(mainOrder);
            if(orderAdd == 0){
                return AppResponse.versionError("主订单新增失败",1);
            }
            //新增订单详情
            for(OrderInfo detail:entry.getValue()){
                OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
                orderDetailInfo.setOrderId(mainOrder.getId());
                orderDetailInfo.setGoodsId(detail.getGoodsIds());
                orderDetailInfo.setGoodsName(detail.getGoodsNames());
                orderDetailInfo.setGoodsImg(detail.getGoodsImg());
                orderDetailInfo.setGoodsDesc(detail.getGoodsDesc());
                orderDetailInfo.setGoodsCount(detail.getGoodsCounts());
                orderDetailInfo.setGoodsPrice(detail.getGoodsPrices());
                int orderDetail = orderDao.orderDetailAdd(orderDetailInfo);
                if(orderDetail == 0){
                    return AppResponse.versionError("订单详情生成失败");
                }
            }
        }
        //若为购物车，则删除购物车
        if(orderInfo.getInstantIndex().equals("0") ){
            List<String> shopCardIds = Arrays.asList(orderInfo.getShopCarIds().split(","));
            int delete = shopcarDao.deleteShopCar(shopCardIds);
            if(delete == 0){
                throw new RuntimeException("删除失败");
            }
        }

//        注释orderInfo:userId、addressId、totalPrice、allCount、state
        int a =0;
        return AppResponse.success("新增成功",listMap);
    }

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse orderList(OrderInfo orderInfo){
        List<OrderDatainfo> orderDataInfo = new ArrayList<>();
        //查询总订单列表
        List<OrderInfo> orderInfoList = orderDao.orderList(orderInfo);
        for(int i = 0; i<orderInfoList.size(); i++){
            List<OrderDetailInfo> orderDetailInfoList = orderDao.orderDetailList(orderInfoList.get(i).getId());
            OrderDatainfo orderDatainfo1 = new OrderDatainfo();
            orderDatainfo1.setOrder(orderInfoList.get(i));
            orderDatainfo1.setOrderDetailList(orderDetailInfoList);
            orderDataInfo.add(orderDatainfo1);
        }
        return AppResponse.success("查询成功",orderDataInfo);
    }

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    public AppResponse getOrderById(String id){
        OrderInfo orderInfo = orderDao.getOrderById(id);
        List<OrderDetailInfo> orderDetailInfoList = orderDao.orderDetailList(id);
        OrderDatainfo orderDatainfo = new OrderDatainfo();
        orderDatainfo.setOrder(orderInfo);
        orderDatainfo.setOrderDetailList(orderDetailInfoList);
        return AppResponse.success("查询成功",orderDatainfo);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    public AppResponse updateOrderState(OrderInfo orderInfo){
        int updateState = orderDao.updateOrderState(orderInfo);
        return AppResponse.success("成功",updateState);
    }

}
