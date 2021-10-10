package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.ShopInfo;
import xmt.item.webapp.service.ShopcarService;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("shopCar")
public class ShopcarController {

    @Resource
    private ShopcarService shopcarService;

    /**
     * 加入购物车
     * @param shopInfo
     * @return
     */
    @GetMapping("/add")
    public AppResponse addShopCar(ShopInfo shopInfo){
        return shopcarService.addShopCar(shopInfo);
    }

    /**
     * 购物车列表
     * @param shopInfo
     * @return
     */
    @GetMapping("/list")
    public AppResponse listUserShopCar(ShopInfo shopInfo){
        return shopcarService.listUserShopCar(shopInfo);
    }
}
