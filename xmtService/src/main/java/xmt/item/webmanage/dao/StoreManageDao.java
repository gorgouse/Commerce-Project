package xmt.item.webmanage.dao;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webmanage.entity.*;

import java.util.List;

@Mapper
public interface StoreManageDao {
    /**
     * 一级分类
     */
    List<ClassifyInfo> getFirstClassify();

    /***
     * 二级分裂
     */
    List<ClassifyInfo> getSecondClassify(String classifyId);

    /**
     * 商品管理
     * @return
     */
    List<CommodityInfo>goodsManageSelect(CommodityInfo commodityInfo);

    /**
     * 新增商品类型
     * @param typeInfo
     * @return
     */
    int addType(TypeInfo typeInfo);

    /**
     * 新增商品属性
     * @param propInfo
     * @return
     */
    int addProp(PropInfo propInfo);

    /**
     * 商品新增
     * @param commodityInfo
     * @return
     */
    int addGoods(CommodityInfo commodityInfo);

    /**
     * 修改商品
     * @param commodityInfo
     * @return
     */
    int updateGoods(CommodityInfo commodityInfo);

    /**
     * 删除商品
     * @param commodityInfo
     * @return
     */
    int deleteGoods(CommodityInfo commodityInfo);

    /**
     * 店铺订单详情查询
     * @param storeOrderDetail
     * @return
     */
    List<StoreOrderDetail> storeOrderDetail(StoreOrderDetail storeOrderDetail);

    /**
     *店铺信息查询
     * @param storeMessageInfo
     * @return
     */
    StoreMessage storeMessageSelect(StoreMessage storeMessageInfo);

    /**
     * 修改店铺信息
     * @param storeMessageInfo
     * @return
     */
    int updateStore(StoreMessage storeMessageInfo);

    /**
     * 轮播申请
     * @param carouselInfo
     * @return
     */
    int slideApply(CarouselInfo carouselInfo);

    /**
     * 修改商品轮播图状态
     */
    int updateGoodsSlide(CarouselInfo carouselInfo);

    /**
     * 店长个人信息
     * @param personalMsgInfo
     * @return
     */
    PersonalMsgInfo storePersonalSelect(PersonalMsgInfo personalMsgInfo);

    /**
     * 个人信息查询
     * @param personalMsgInfo
     * @return
     */
    PersonalMsgInfo personalSelect(PersonalMsgInfo personalMsgInfo);

    /**
     * 修改店长个人信息
     * @param personalMsgInfo
     * @return
     */
    int updateStorePersonal(PersonalMsgInfo personalMsgInfo);

    /**
     *
     * @param personalMsgInfo
     * @return
     */
    int updatePersonal(PersonalMsgInfo personalMsgInfo);
    /**
     * 查询店铺总订单
     * @param shopManageId
     * @return
     */
    List<OrderInfo> selectMainOrderOfStore(String shopManageId);
}
