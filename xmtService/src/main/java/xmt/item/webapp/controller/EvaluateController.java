package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.EvaluateInfo;
import xmt.item.webapp.service.EvaluateService;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/evaluate")
public class EvaluateController {

    @Resource
    private EvaluateService evaluateService;

    /**
     * 新增评价
     * @param evaluateInfo
     * @return
     */
    @GetMapping("/add")
    public AppResponse addEvaluate(EvaluateInfo evaluateInfo){
        return evaluateService.addEvaluate(evaluateInfo);
    }

    /**
     * 查询商品详情评价
     * @param goodsId
     * @return
     */
    @GetMapping("/select")
    public AppResponse selectGoodsDetailEvaluate(String goodsId){
        return evaluateService.selectGoodsDetailEvaluate(goodsId);
    }

    /**
     * 查询商品详情评价总数
     * @param goodsId
     * @return
     */
    @GetMapping("/count")
    public AppResponse countGoodsDetailEvaluateTotal(String goodsId){
        return evaluateService.countGoodsDetailEvaluateTotal(goodsId);
    }
}
