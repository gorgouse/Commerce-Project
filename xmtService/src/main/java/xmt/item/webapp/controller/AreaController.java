package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.AreaInfo;
import xmt.item.webapp.service.AreaService;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    /**
     * 查询省
     * @return
     */
    public AppResponse getProvinceList(){
        return areaService.getProvinceList();
    }

    /**
     * 获取所有区域列表
     * @return
     */
    @GetMapping("/getAreaList")
    public AppResponse getAreaList(){
        return areaService.getAreaList();
    }

    /**
     * 查询子区域
     * @param areaInfo
     * @return
     */
    public AppResponse getSubDomain(AreaInfo areaInfo){
        return areaService.getSubDomain(areaInfo);
    }

}
