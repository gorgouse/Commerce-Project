package xmt.item.webmanage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webmanage.dao.StoreManageDao;
import xmt.item.webmanage.entity.*;

import java.util.List;
import javax.annotation.Resource;

@Service
@Transactional
public class StoreManageService {

    @Resource
    private StoreManageDao storeManageDao;

    /**
     * 一级分类
     */
    public AppResponse getFirstClassify(){
        List<ClassifyInfo> classifyInfoList = storeManageDao.getFirstClassify();
        return AppResponse.success("成功",classifyInfoList);
    }

    /**
     * 二级分裂
     */
    public AppResponse getSecondClassify(String classifyId){
        List<ClassifyInfo> classifyInfoList = storeManageDao.getSecondClassify(classifyId);
        return AppResponse.success("成功",classifyInfoList);
    }

    /**
     * 店铺商品查询
     * @param commodityInfo
     * @return
     */
    public AppResponse goodsManageSelect(CommodityInfo commodityInfo){
        List<CommodityInfo>commodityInfoList = storeManageDao.goodsManageSelect(commodityInfo);
        for(CommodityInfo obj:commodityInfoList){
            if(obj.getGoodsState().equals("1")){
                obj.setGoodsState("下架");
            }
            if(obj.getGoodsState().equals("2")){
                obj.setGoodsState("待审核");
            }
            if(obj.getGoodsState().equals("3")){
                obj.setGoodsState("已发布");
            }
            //轮播状态
            if(obj.getSlideState().equals("1")){
                obj.setSlideState("未发布");
            }
            if(obj.getSlideState().equals("2")){
                obj.setSlideState("待审核");
            }
            if(obj.getSlideState().equals("3")){
                obj.setSlideState("已发布");
            }
            if(obj.getSlideState().equals("4")){
                obj.setSlideState("已过期");
            }
        }
        return AppResponse.success("成功",commodityInfoList);
    }

    /**
     *新增商品类型
     * @param typeInfo
     * @return
     */
    public AppResponse addType(TypeInfo typeInfo){
        int add = storeManageDao.addType(typeInfo);
        return AppResponse.success("成功",add);
    }

    /**
     *新增商品属性
     * @param propInfo
     * @return
     */
    public AppResponse addProp(PropInfo propInfo){
        int add = storeManageDao.addProp(propInfo);
        return AppResponse.success("成功",add);
    }

    /**
     * 商品新增
     * @param commodityInfo
     * @return
     */
    public AppResponse addGoods(CommodityInfo commodityInfo){
        int add = storeManageDao.addGoods(commodityInfo);
        return AppResponse.success("成功",add);
    }

    /**
     * 修改商品
     * @param commodityInfo
     * @return
     */
    public AppResponse updateGoods(CommodityInfo commodityInfo){
        int update = storeManageDao.updateGoods(commodityInfo);
        return AppResponse.success("成功",update);
    }

    /**
     * 删除商品
     * @param commodityInfo
     * @return
     */
    public AppResponse deleteGoods(CommodityInfo commodityInfo){
        int delete = storeManageDao.deleteGoods(commodityInfo);
        return AppResponse.success("成功",delete);
    }

    /**
     * 店铺订单详情查询
     * @param storeOrderDetail
     * @return
     */
    public AppResponse storeOrderDetail(StoreOrderDetail storeOrderDetail){
        List<StoreOrderDetail> storeOrderDetailList = storeManageDao.storeOrderDetail(storeOrderDetail);
        return AppResponse.success("成功",storeOrderDetailList);
    }

    /**
     *店铺查询
     * @param storeMessageInfo
     * @return
     */
    public AppResponse storeMessageSelect(StoreMessage storeMessageInfo){
        StoreMessage storeMessageInfoList = storeManageDao.storeMessageSelect(storeMessageInfo);
        return AppResponse.success("成功",storeMessageInfoList);
    }

    /**
     * 修改店铺信息
     * @param storeMessageInfo
     * @return
     */
    public AppResponse updateStore(StoreMessage storeMessageInfo){
        int update1 = storeManageDao.updateStore(storeMessageInfo);
        return AppResponse.success("成功",update1);
    }

    /**
     * 轮播申请
     * @param carouselInfo
     * @return
     */
    public AppResponse slideApply(CarouselInfo carouselInfo){
        int add = storeManageDao.slideApply(carouselInfo);
        return AppResponse.success("成功",add);
    }

    public AppResponse updateGoodsSlide(CarouselInfo carouselInfo){
        int update = storeManageDao.updateGoodsSlide(carouselInfo);
        return AppResponse.success("成功",update);
    }

    /**
     * 个人信息查询
     * @param personalMsgInfo
     * @return
     */
    public AppResponse personalSelect(PersonalMsgInfo personalMsgInfo){
        PersonalMsgInfo personalMsgInfo1 = null;
        if(personalMsgInfo.getRole().equals("3")){
            personalMsgInfo1 = storeManageDao.storePersonalSelect(personalMsgInfo);
        }
        else{
            personalMsgInfo1 = storeManageDao.personalSelect(personalMsgInfo);
        }
        return AppResponse.success("成功",personalMsgInfo1);
    }

    /**
     * 修改个人信息
     * @param personalMsgInfo
     * @return
     */
    public AppResponse updatePersonal(PersonalMsgInfo personalMsgInfo){
        int update = 0;
        if(personalMsgInfo.getRole().equals("3")){
            update = storeManageDao.updateStorePersonal(personalMsgInfo);
        }
        else{
            update = storeManageDao.updatePersonal(personalMsgInfo);
        }

        return AppResponse.success("成功",update);
    }

    /**
     * 查询店铺总订单
     * @param
     * @return
     */
    public AppResponse selectMainOrderOfStore(String shopManageId){
        List<OrderInfo> orderInfoList = storeManageDao.selectMainOrderOfStore(shopManageId);
        for(OrderInfo orderInfo:orderInfoList){
            if(orderInfo.getState().equals("2")){
                orderInfo.setState("待发货");
            }
            if(orderInfo.getState().equals("3")){
                orderInfo.setState("完成发货");
            }
            if(orderInfo.getState().equals("4")){
                orderInfo.setState("交易完成");
            }
        }
        return AppResponse.success(("成功"),orderInfoList);
    }
}
