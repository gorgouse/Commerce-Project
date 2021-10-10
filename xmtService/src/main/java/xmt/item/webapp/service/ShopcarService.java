package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.ShopcarDao;
import xmt.item.webapp.entity.ShopInfo;
import java.util.List;

import javax.annotation.Resource;

@Service
@Transactional
public class ShopcarService {

    @Resource
    private ShopcarDao shopcarDao;

    /**
     * 新增购物车
     * @param shopInfo
     * @return
     */
    public AppResponse addShopCar(ShopInfo shopInfo){
            int result = shopcarDao.addShopCar(shopInfo);
            if(result == 0){
                return AppResponse.success("新增成功",0);
            }
        return AppResponse.success("新增成功",0);
    }

    /**
     * 购物车列表
     * @param shopInfo
     * @return
     */
    public AppResponse listUserShopCar(ShopInfo shopInfo){
        List<ShopInfo> shopInfoList = shopcarDao.listUserShopCar(shopInfo);
        return AppResponse.success("查询成功",shopInfoList);
    }
}
