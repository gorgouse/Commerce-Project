package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webapp.entity.StoreInfo;

@Mapper
public interface StoreDao {
    /**
     * 查询通过商品编号查询店铺编号
     * @param goodsId
     * @return
     */
    String getStoreIdByGoodsId(String goodsId);
    /**
     * 查询店铺
     * @param storeInfo
     * @return
     */
    StoreInfo selectStore(StoreInfo storeInfo);

    /**
     * 查询店铺的商品
     * @param storeInfo
     * @return
     */
    List<StoreInfo>selectStoreGoods(StoreInfo storeInfo);

}
