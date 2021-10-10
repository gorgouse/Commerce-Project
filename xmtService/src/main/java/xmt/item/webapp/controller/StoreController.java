package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.StoreInfo;
import xmt.item.webapp.service.StoreService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    /**
     * 查询店铺
     * @param storeInfo
     * @return
     */
    @GetMapping("/select")
    public AppResponse selectStore(StoreInfo storeInfo){
        return storeService.selectStore(storeInfo);
    }

    /**
     * 查询店铺的商品
     * @param storeInfo
     * @return
     */
    @GetMapping("/goods")
    public AppResponse selectStoreGoods(StoreInfo storeInfo){
        return storeService.selectStoreGoods(storeInfo);
    }
}
