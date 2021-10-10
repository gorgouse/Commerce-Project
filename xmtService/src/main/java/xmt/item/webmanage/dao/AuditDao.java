package xmt.item.webmanage.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webmanage.entity.*;

@Mapper
public interface AuditDao {
    /**
     * 审核商品查询
     * @param auditInfo
     * @return
     */
    List<AuditInfo> auditGoods(AuditInfo auditInfo);

    /**
     *修改商品状态:上架或下架
     * @param commodityInfo
     * @return
     */
    int auditGoodsUpdate(CommodityInfo commodityInfo);

    /**
     * 店铺注册新增审核
     * @param auditInfo
     * @return
     */
    Integer auditStoreRegister(AuditInfo auditInfo);

    /**
     * 注册店长
     * @param personalMsgInfo
     * @return
     */
    int storeManageRegister(PersonalMsgInfo personalMsgInfo);

    /**
     * 注册店铺
     * @param storeMessageInfo
     * @return
     */
    int storeRegister(StoreMessage storeMessageInfo);

    /**
     * 删除审核表中的数据
     * @param auditInfo
     * @return
     */
    int deleteAuditOfStoreRegister(AuditInfo auditInfo);

    /***
     * 查询店铺审核
     * @return
     */
    List<AuditInfo> selectAuditStoreRegister();

    /**
     *新增店铺审核
     * @param
     * @return
     */
    int auditSlideAdd(RegisterManageInfo registerManageInfo);

    /**
     *轮播图审核删除
     * @param id
     * @return
     */
    int auditSlideDelete(String goodsId);

    /**
     *轮播图审核查询
     * @param registerManageInfo
     * @return
     */
    List<RegisterManageInfo>auditSlideSelect(RegisterManageInfo registerManageInfo);

    /**
     * 新增轮播图
     * @param carouselInfo
     * @return
     */
    int addSlide(CarouselInfo carouselInfo);
}
