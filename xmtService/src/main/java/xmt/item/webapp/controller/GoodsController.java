package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.*;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.GoodsInfo;
import xmt.item.webapp.entity.PropInfo;
import xmt.item.webapp.entity.TypeInfo;
import xmt.item.webapp.service.GoodsService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/appgoods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 首页搜索
     * @param goodsInfo
     * @return
     */
    @GetMapping("/search")
    public AppResponse goodsSearch(GoodsInfo goodsInfo){
        return goodsService.goodsSearch(goodsInfo);
    }

    /**
     * 首页商品
     * @return
     */
    @GetMapping("/homeGoodsList")
    public AppResponse homeGoodsList(){
        return goodsService.homeGoodsList();
    }

    /**
     * 查询商品一级分类
     */
    @GetMapping("/firstClassify")
    public AppResponse firstClassify(){
        return goodsService.firstClassify();
    }

    /**
     * 查询二级分类及其商品
     * @param classifyId
     * @return
     */
    @GetMapping("/getGoodsBySort")
    public AppResponse getGoodsBySort(String classifyId){
        return goodsService.getGoodsBySort(classifyId);
    }

    /**
     * 点击客服加入聊天
     */
    @GetMapping("addChatByClickClientService")
    public AppResponse addChatByClickClientService(String goodsId){
        return goodsService.addChatByClickClientService(goodsId);
    }
    /**
     * 商品详情
     */
    @GetMapping("detail")
    public AppResponse selectGoodsById(String goodId){
        return goodsService.selectGoodsById(goodId);
    }

    /**
     * 查询详情图片
     * @param goodsId
     * @return
     */
    @CrossOrigin
    @GetMapping("/detailImage")
    public AppResponse selectDetailImage(String goodsId){
        return goodsService.selectDetailImage(goodsId);
    }

    /**
     * 查询商品类型
     * @param typeInfo
     * @return
     */
    @GetMapping("/type")
    public AppResponse selectTypeOfGoods(TypeInfo typeInfo){return goodsService.selectTypeOfGoods(typeInfo);}

    /**
     * 查询商品属性
     * @param propInfo
     * @return
     */
    @GetMapping("/prop")
    public AppResponse selectPropOfGoods(PropInfo propInfo){
        return goodsService.selectPropOfGoods(propInfo);
    }
}
