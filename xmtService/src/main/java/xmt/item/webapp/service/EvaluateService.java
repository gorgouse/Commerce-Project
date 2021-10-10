package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.EvaluateDao;
import xmt.item.webapp.entity.EvaluateInfo;
import java.util.List;
import javax.annotation.Resource;

@Service
@Transactional
public class EvaluateService {
    @Resource
    private EvaluateDao evaluateDao;

    /**
     * 新增评价
     * @param evaluateInfo
     * @return
     */
    public AppResponse addEvaluate(EvaluateInfo evaluateInfo){
        int add = evaluateDao.addEvaluate(evaluateInfo);
        return AppResponse.success("成功",add);
    }

    /**
     * 查询商品详情评价
     * @param goodsId
     * @return
     */
    public AppResponse selectGoodsDetailEvaluate(String goodsId){
        List<EvaluateInfo> evaluateInfoList = evaluateDao.selectGoodsDetailEvaluate(goodsId);
        return AppResponse.success("成功",evaluateInfoList);
    }

    /**
     * 查询商品详情评价总数
     * @param goodsId
     * @return
     */
    public AppResponse countGoodsDetailEvaluateTotal(String goodsId){
        int count = evaluateDao.countGoodsDetailEvaluateTotal(goodsId);
        return AppResponse.success("成功",count);
    }
}
