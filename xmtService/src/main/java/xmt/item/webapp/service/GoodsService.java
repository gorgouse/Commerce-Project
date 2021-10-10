package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.GoodsDao;
import xmt.item.webapp.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

@Service
@Transactional
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     * 首页搜索
     */
    public AppResponse goodsSearch(GoodsInfo goodsInfo){
        List<GoodsInfo> goodsInfoList = goodsDao.goodsSearch(goodsInfo);
        return AppResponse.success("查询成功",goodsInfoList);
    }

    /**
     *查询商品一级分类
     * @return
     */
    public AppResponse firstClassify(){
        List<SortInfo> sortInfoList = goodsDao.firstClassify();
        return AppResponse.success("成功",sortInfoList);
    }

    /**
     *查询全部分类列表及其商品
     * @param classifyId
     * @return
     */
    public AppResponse getGoodsBySort(String classifyId){
        List<HashMap<String,Object>> hashMapList = new ArrayList<>();
        List<SortInfo> sortInfoList = goodsDao.secondClassify(classifyId);
        for(SortInfo sortInfo:sortInfoList){
            HashMap<String,Object> hashMap = new HashMap<>();
            List<GoodsInfo> goodsInfoList = goodsDao.getGoodsBySort(sortInfo.getId());
            hashMap.put("secondClassifyId",sortInfo.getId());
            hashMap.put("classifySecondName",sortInfo.getName());
            hashMap.put("goodsList",goodsInfoList);
            hashMapList.add(hashMap);
        }
        return AppResponse.success("成功",hashMapList);

    }

    /**
     * 商品显示列表
     */
    public AppResponse homeGoodsList(){
        List<GoodsInfo> goodsInfoList = goodsDao.homeGoodsList();
        return AppResponse.success("查询成功",goodsInfoList);
    }

    /**
     * 商品详情
     */
    public AppResponse selectGoodsById(String goodId){
        GoodsInfo goodsInfo = goodsDao.selectGoodsById(goodId);
        return AppResponse.success("查询成功",goodsInfo);
    }

    /**
     * 点击客服加入聊天
     */
    public AppResponse addChatByClickClientService(String goodsId){
        StoreInfo storeInfo = goodsDao.addChatByClickClientService(goodsId);
        return AppResponse.success("查询成功",storeInfo);
    }

    /**
     * 查询详情图片
     * @param goodsId
     * @return
     */
    public AppResponse selectDetailImage(String goodsId){
        List<DetailImageInfo> detailImageInfoList = goodsDao.selectDetailImage(goodsId);
        return AppResponse.success("成功",detailImageInfoList);
    }
    /**
     * 查询商品类型
     * @param typeInfo
     * @return
     */
    public AppResponse selectTypeOfGoods(TypeInfo typeInfo){
        List<TypeInfo> typeInfoList = goodsDao.selectTypeOfGoods(typeInfo);
        return AppResponse.success("查询成功",typeInfoList);
    }

    /**
     * 查询商品属性
     * @param propInfo
     * @return
     */
    public AppResponse selectPropOfGoods(PropInfo propInfo){
        List<PropInfo> propInfoList = goodsDao.selectPropOfGoods(propInfo);
        return AppResponse.success("查询成功",propInfoList);
    }

}
