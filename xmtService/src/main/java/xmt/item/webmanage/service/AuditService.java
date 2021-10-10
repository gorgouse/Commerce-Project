package xmt.item.webmanage.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.util.StringUtil;
import xmt.item.webmanage.dao.AuditDao;
import xmt.item.webmanage.entity.*;

import javax.annotation.Resource;

@Service
public class AuditService {
    @Resource
    private AuditDao auditDao;

    /**
     * 商品审核
     * @param auditInfo
     * @return
     */
    public AppResponse auditGoods(AuditInfo auditInfo,int pageNum,int pageSize){
        List<AuditInfo> auditInfoList = auditDao.auditGoods(auditInfo);
        for(AuditInfo obj:auditInfoList){
            if(obj.getGoodsState().equals("1")){
                obj.setGoodsState("下架");
            }
            if(obj.getGoodsState().equals("2")){
                obj.setGoodsState("待审核");
            }
            if(obj.getGoodsState().equals("3")){
                obj.setGoodsState("已发布");
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<AuditInfo> pageInfo = new PageInfo<>(auditInfoList);
        return AppResponse.success("成功",pageInfo);
    }

    /**
     * 修改商品状态:上架或下架
     * @param commodityInfo
     * @return
     */
    public AppResponse auditGoodsUpdate(CommodityInfo commodityInfo){
        int update = auditDao.auditGoodsUpdate(commodityInfo);
        if(commodityInfo.getGoodsState().equals('3')){
            return AppResponse.success("上架成功",update);
        }
        if(commodityInfo.getGoodsState().equals('1')){
            return AppResponse.success("下架成功",update);
        }
        return AppResponse.success("成功",update);
    }

    /**
     * 店铺注册新增审核
     * @param auditInfo
     * @return
     */
    public AppResponse auditStoreRegister(AuditInfo auditInfo){
        Integer result = auditDao.auditStoreRegister(auditInfo);
        return AppResponse.success("成功",result);
    }

    /**
     *店铺审核通过
     * @param auditInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storeAuditPass(AuditInfo auditInfo){
        String userId = StringUtil.getCommonCode(1);
        PersonalMsgInfo personalMsgInfo = new PersonalMsgInfo();
          personalMsgInfo.setUserId(userId);

        personalMsgInfo.setAcct(auditInfo.getUsername());
        personalMsgInfo.setPassword(auditInfo.getPassword());
        personalMsgInfo.setShopManageName(auditInfo.getShopManager());
        personalMsgInfo.setIdCard(auditInfo.getIdCard());
        personalMsgInfo.setEmail(auditInfo.getEmail());
        personalMsgInfo.setPhone(auditInfo.getPhone());
        personalMsgInfo.setImg(auditInfo.getImg());
        personalMsgInfo.setCreateTime(auditInfo.getBornDate());
        //新增店长
        int add = auditDao.storeManageRegister(personalMsgInfo);
        StoreMessage storeMessageInfo = new StoreMessage();
        storeMessageInfo.setStoreName(auditInfo.getStoreName());
        storeMessageInfo.setStoreImg(auditInfo.getStoreImg());
        storeMessageInfo.setLicenseAddress(auditInfo.getLicenseAddress());
        storeMessageInfo.setLicenseAcct(auditInfo.getLicenseAcct());
        storeMessageInfo.setLicenseType(auditInfo.getLicenseType());
        storeMessageInfo.setCreateTime(auditInfo.getBornDate());//bornDate
        storeMessageInfo.setUserId(userId);
        //新增店铺
        int add_store = auditDao.storeRegister(storeMessageInfo);
        //删除审核
        int delete_result = auditDao.deleteAuditOfStoreRegister(auditInfo);
        return AppResponse.success("成功",add+""+add_store+""+delete_result);
    }

//    审核不通过
    public AppResponse storeAuditNotPass(AuditInfo auditInfo){
        int delete = auditDao.deleteAuditOfStoreRegister(auditInfo);
        return AppResponse.success("成功",delete);
    }

    /**
     * 查询店铺审核
     * @return
     */
    public AppResponse selectAuditStoreRegister(int pageNum,int pageSize){
        List<AuditInfo> auditInfoList = auditDao.selectAuditStoreRegister();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<AuditInfo> pageInfo = new PageInfo<>(auditInfoList);
        return AppResponse.success("成功",pageInfo);
    }

    /**
     *新增店铺审核
     * @param registerManageInfo
     * @return
     */
    public AppResponse auditSlideAdd(RegisterManageInfo registerManageInfo){
        int addResult = auditDao.auditSlideAdd(registerManageInfo);
        return AppResponse.success("成功",addResult);
    }

    /**
     * 新增轮播图
     * @param carouselInfo
     * @return
     */
    public AppResponse addSlide(CarouselInfo carouselInfo){
        int add = auditDao.addSlide(carouselInfo);
        return AppResponse.success("成功",add);
    }

    /**
     *轮播图审核删除
     * @param goodsId
     * @return
     */
    public AppResponse auditSlideDelete(String goodsId){
        int deleteResult = auditDao.auditSlideDelete(goodsId);
        return AppResponse.success("删除成功",deleteResult);
    }

    /**
     *轮播图审核查询
     * @param registerManageInfo
     * @return
     */
    public AppResponse auditSlideSelect(RegisterManageInfo registerManageInfo){
        List<RegisterManageInfo> registerManageInfoList = auditDao.auditSlideSelect(registerManageInfo);
        return AppResponse.success("查询成功",registerManageInfoList);
    }

}
