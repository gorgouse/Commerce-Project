package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.*;

@Mapper
public interface GoodsDao {
    /**
     * 商品搜索
     * @param goodsInfo
     * @return
     */
   List<GoodsInfo> goodsSearch(GoodsInfo goodsInfo);

    /**
     * 商品显示列表
     * @param
     * @return
     */
   List<GoodsInfo> homeGoodsList();

    /**
     *查询商品一级分类
     * @return
     */
    List<SortInfo> firstClassify();

    /**
     *查询二级分类及其商品
     * @param classifyId
     * @return
     */
    List<SortInfo> secondClassify(String classifyId);

    /**
     *
     * @param SecondClassify
     * @return
     */
    List<GoodsInfo> getGoodsBySort(String SecondClassify);

    /**
     * 点击客服加入聊天
     * @param goodsId
     * @return
     */
    StoreInfo addChatByClickClientService(String goodsId);

    /**
     * 商品详情
     * param
     * @return
     */
    GoodsInfo selectGoodsById(String id);

 /**
  *查询详情图片
  * @param goodsId
  * @return
  */
 List<DetailImageInfo> selectDetailImage(String goodsId);

    /**
     * 查询商品类型/品种
     * @param typeInfo
     * @return
     */
    List<TypeInfo> selectTypeOfGoods(TypeInfo typeInfo);

    /**
     * 查询商品属性
     * @param propInfo
     * @return
     */
    List<PropInfo> selectPropOfGoods(PropInfo propInfo);
}
