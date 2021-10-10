package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.StoreDao;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webapp.entity.StoreInfo;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 查询店铺
     * @param storeInfo
     * @return
     */
    public AppResponse selectStore(StoreInfo storeInfo){
        StoreInfo storeInfo1 = storeDao.selectStore(storeInfo);
        return AppResponse.success("成功",storeInfo1);
    }

    /**
     * 查询店铺的商品
     * @param storeInfo
     * @return
     */
    public AppResponse selectStoreGoods(StoreInfo storeInfo){
        List<StoreInfo> storeInfoList = storeDao.selectStoreGoods(storeInfo);
        return AppResponse.success("成功",storeInfoList);
    }

}
