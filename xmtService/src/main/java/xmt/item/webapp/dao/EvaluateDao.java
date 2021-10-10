package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.EvaluateInfo;

@Mapper
public interface EvaluateDao {
    /**
     * 新增评价
     * @param evaluateInfo
     * @return
     */
    int addEvaluate(EvaluateInfo evaluateInfo);

    /**
     * 查询商品详情评价
     * @param goodsId
     * @return
     */
    List<EvaluateInfo> selectGoodsDetailEvaluate(String goodsId);

    /**
     * 查询商品详情评价总数
     * @param goodsId
     * @returncountGoodsDetailEvaluateTotal
     */
    int countGoodsDetailEvaluateTotal(String goodsId);
}
