package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.AreaDao;
import xmt.item.webapp.entity.AreaInfo;
import xmt.item.webapp.entity.AreaList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

@Service
@Transactional
public class AreaService {
    @Resource
    private AreaDao areaDao;

    /**
     * 获取所有区域列表
     */
    public AppResponse getAreaList(){
        AreaList areaList = new AreaList();

        List<AreaInfo> provinceData = areaDao.getProvinceList();
        HashMap<String,Object> hashMapProvince = new HashMap<>();
        for (AreaInfo areaInfo:provinceData) {
            hashMapProvince.put(areaInfo.getProvince(),areaInfo.getName());
        }

        List<AreaInfo> cityData = areaDao.getCityList();
        HashMap<String,Object> hashMapCity = new HashMap<>();
        for (AreaInfo areaInfo:cityData){
            hashMapCity.put(areaInfo.getCity(),areaInfo.getName());
        }

        List<AreaInfo> areaData = areaDao.getAreaList();
        HashMap<String,Object> hashMapArea = new HashMap<>();
        for(AreaInfo areaInfo:areaData){
            hashMapArea.put(areaInfo.getCity(),areaInfo.getName());
        }
        areaList.setProvince_list(hashMapProvince);
        areaList.setCity_list(hashMapCity);
        areaList.setCounty_list(hashMapArea);

        return AppResponse.success("查询成功",areaList);
    }

    /**
     * 查询省
     * @return
     */
    public AppResponse getProvinceList(){
        return AppResponse.success("查询成功",areaDao.getProvinceList());
    }

    /**
     * 查询子区域
     * @param areaInfo
     * @return
     */
    public AppResponse getSubDomain(AreaInfo areaInfo){
        return AppResponse.success("查询成功",areaDao.getSubDomain(areaInfo));
    }

}
