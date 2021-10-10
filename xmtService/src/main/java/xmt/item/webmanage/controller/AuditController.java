package xmt.item.webmanage.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webmanage.entity.AuditInfo;
import xmt.item.webmanage.entity.CarouselInfo;
import xmt.item.webmanage.entity.CommodityInfo;
import xmt.item.webmanage.entity.RegisterManageInfo;
import xmt.item.webmanage.service.AuditService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/audit")
public class AuditController {
    @Resource
    private AuditService auditService;

    /**
     * 商品审核
     * @param auditInfo
     * @return
     */
    @GetMapping("goods")
    public AppResponse auditInfoList(AuditInfo auditInfo,int pageNum,int pageSize){
        return auditService.auditGoods(auditInfo,pageNum,pageSize);
    }

    /**
     * 修改商品状态:上架或下架
     * @param commodityInfo
     * @return
     */
    @GetMapping("/auditGoodsUpdate")
    public AppResponse auditGoodsUpdate(CommodityInfo commodityInfo){
        return auditService.auditGoodsUpdate(commodityInfo);
    }

    /**
     * 店铺注册新增审核
     * @param auditInfo
     * @return
     */
    @GetMapping("storeRegister")
    public AppResponse storeRegister(AuditInfo auditInfo){
        return auditService.auditStoreRegister(auditInfo);
    }

    /**
     *店铺审核通过
     * @param auditInfo
     * @return
     */
    @GetMapping("/storeAuditPass")
    public AppResponse storeAuditPass(AuditInfo auditInfo){
        return auditService.storeAuditPass(auditInfo);
    }

    /**
     * 店铺审核不通过
     * @param auditInfo
     * @return
     */
    @GetMapping("/storeAuditNotPass")
    public AppResponse storeAuditNotPass(AuditInfo auditInfo){
        return auditService.storeAuditNotPass(auditInfo);
    }

    /**
     * 查询店铺审核
     * @return
     */
    @GetMapping("/selectAuditStoreRegister")
    public AppResponse selectAuditStoreRegister(int pageNum,int pageSize){
        return auditService.selectAuditStoreRegister(pageNum,pageSize);
    }

    /**
     *轮播图审核新增
     * @return
     */
    @GetMapping("/auditSlideAdd")
    public AppResponse auditSlideAdd(RegisterManageInfo registerManageInfo){
        return auditService.auditSlideAdd(registerManageInfo);
    }

    /**
     *轮播图审核删除
     * @return
     */
    @GetMapping("/auditSlideDelete")
    public AppResponse auditSlideDelete(String goodsId){
        return auditService.auditSlideDelete(goodsId);
    }

    /**
     *轮播图审核查询
     * @return
     */
    @GetMapping("/auditSlideSelect")
    public AppResponse auditSlideSelect(RegisterManageInfo registerManageInfo){
        return auditService.auditSlideSelect(registerManageInfo);
    }

    /**
     * 新增轮播图
     * @param carouselInfo
     * @return
     */
    @GetMapping("/addSlide")
    public AppResponse addSlide(CarouselInfo carouselInfo){
        return auditService.addSlide(carouselInfo);
    }

}
