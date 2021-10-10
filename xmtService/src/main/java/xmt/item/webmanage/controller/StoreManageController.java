package xmt.item.webmanage.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webmanage.entity.*;
import xmt.item.webmanage.service.StoreManageService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/storeManage")
public class StoreManageController {
    @Resource
    private StoreManageService storeManageService;

    /**
     * 一级分类
     * @param
     * @return
     */
    @GetMapping("/getFirstClassify")
    public AppResponse getFirstClassify(){
        return storeManageService.getFirstClassify();
    }

    /**
     * 二级分裂
     * @param classifyId
     * @return
     */
    @GetMapping("/getSecondClassify")
    public AppResponse getSecondClassify(String classifyId){
        return storeManageService.getSecondClassify(classifyId);
    }


    /**
     * 商品查询
     * @param commodityInfo
     * @return
     */
    @GetMapping("/goodsManageSelect")
    public AppResponse goodsManageSelect(CommodityInfo commodityInfo){
        return storeManageService.goodsManageSelect(commodityInfo);
    }

    /**
     * 新增商品类型
     * @param typeInfo
     * @return
     */
    @GetMapping("/addType")
    public AppResponse addType(TypeInfo typeInfo){
        return storeManageService.addType(typeInfo);
    }

    /**
     * 新增商品属性
     * @param propInfo
     * @return
     */
    @GetMapping("/addProp")
    public AppResponse addProp(PropInfo propInfo){
        return storeManageService.addProp(propInfo);
    }

    /**
     * 商品新增
     * @param commodityInfo
     * @return
     */
    @GetMapping("/addGoods")
    public AppResponse addGoods(CommodityInfo commodityInfo){
        return storeManageService.addGoods(commodityInfo);
    }

    /**
     * 修改商品
     * @param commodityInfo
     * @return
     */
    @GetMapping("/updateGoods")
    public AppResponse updateGoods(CommodityInfo commodityInfo){
        return storeManageService.updateGoods(commodityInfo);
    }

    /**
     * 删除商品
     * @param commodityInfo
     * @return
     */
    @GetMapping("/deleteGoods")
    public AppResponse deleteGoods(CommodityInfo commodityInfo){
        return storeManageService.deleteGoods(commodityInfo);
    }

    /**
     * 店铺订单详情查询
     * @param storeOrderDetail
     * @return
     */
    @GetMapping("/storeOrderDetail")
    public AppResponse storeOrderDetail(StoreOrderDetail storeOrderDetail){
        return storeManageService.storeOrderDetail(storeOrderDetail);
    }

    /**
     *店铺信息
     * @param storeMessageInfo
     * @return
     */
    @GetMapping("/storeMessageSelect")
    public AppResponse storeMessageSelect(StoreMessage storeMessageInfo){
        return storeManageService.storeMessageSelect(storeMessageInfo);
    }

    /**
     * 修改店铺信息
     * @param storeMessageInfo
     * @return
     */
    @GetMapping("/updateStore")
    public AppResponse updateStore(StoreMessage storeMessageInfo){
        return storeManageService.updateStore(storeMessageInfo);
    }

    /**
     * 轮播申请
     * @param carouselInfo
     * @return
     */
    @GetMapping("slideApply")
    public AppResponse slideApply(CarouselInfo carouselInfo){
        return storeManageService.slideApply(carouselInfo);
    }

    /**
     *
     * @param carouselInfo
     * @return
     */
    @GetMapping("/updateGoodsSlide")
    public AppResponse updateGoodsSlide(CarouselInfo carouselInfo){
        return storeManageService.updateGoodsSlide(carouselInfo);
    }

    /**
     * 个人信息查询
     * @param personalMsgInfo
     * @return
     */
    @GetMapping("/personalSelect")
    public AppResponse personalSelect(PersonalMsgInfo personalMsgInfo){
        return storeManageService.personalSelect(personalMsgInfo);
    }

    /**
     * 修改信息查询
     * @param personalMsgInfo
     * @return
     */
    @GetMapping("/updatePersonal")
    public AppResponse updatePersonal(PersonalMsgInfo personalMsgInfo){
        return storeManageService.updatePersonal(personalMsgInfo);
    }

    /**
     * 查询店铺总订单
     * @param shopManageId
     * @return
     */
    @GetMapping("/selectMainOrderOfStore")
    public AppResponse selectMainOrderOfStore(String shopManageId){
        return storeManageService.selectMainOrderOfStore(shopManageId);
    }
}
