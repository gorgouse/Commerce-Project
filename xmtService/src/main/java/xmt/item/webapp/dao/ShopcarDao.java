package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.ShopInfo;

@Mapper
public interface ShopcarDao {
    /**
     * 加入购物车
     * @param shopInfo
     * @return
     */
    int addShopCar(ShopInfo shopInfo);

    /**
     * 修改购物车数量
     * @param shopInfo
     * @return
     */
    int updateShopCar(ShopInfo shopInfo);

    /**
     * 查询购物车列表中是否已有该商品
     * @param shopInfo
     * @return
     */
    ShopInfo hasGoodsIdInShopCar(ShopInfo shopInfo);

    /**
     * 购物车列表
     * @param shopInfo
     * @return
     */
    List<ShopInfo> listUserShopCar(ShopInfo shopInfo);

    /**
     * 删除购物车
     * @param shopCardIdList
     * @return
     */
    int deleteShopCar(List<String> shopCardIdList);
}
