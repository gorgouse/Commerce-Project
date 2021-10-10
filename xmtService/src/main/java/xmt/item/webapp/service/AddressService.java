package xmt.item.webapp.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.AddressDao;
import xmt.item.webapp.dao.AreaDao;
import xmt.item.webapp.entity.AddressInfo;

import javax.annotation.Resource;

@Service
@Transactional
public class AddressService {
    @Resource
    private AddressDao addressDao;
    @Resource
    private AreaDao areaDao;

    /**
     * 新增收货地址
     * @param addressInfo
     * @return
     */
    public AppResponse addAddress(AddressInfo addressInfo){
        addressInfo.setAddressDetail(addressInfo.getProvince()+""+addressInfo.getCity()+""+addressInfo.getCounty()+""+addressInfo.getAddressDetail());
        addressInfo.setProvince(areaDao.getId(addressInfo.getProvince()));
        addressInfo.setCity(areaDao.getId(addressInfo.getCity()));
        addressInfo.setCounty(areaDao.getId(addressInfo.getCounty()));
        //遍历地址修改默认
        if(addressInfo.getIsDefault().equals("true")){
            int isFirst = addressDao.isFirst(addressInfo.getUserId());
            if(isFirst != 0){
                int updateDefault = addressDao.selectDefaultAsFault(addressInfo.getUserId());
                if(updateDefault == 0){
                    return AppResponse.versionError("设置默认失败","设置默认失败");
                }
            }
        }
        int result = addressDao.addAddress(addressInfo);
       return AppResponse.success("新增成功",result);
    }

    /**
     * 收货地址列表
     * @param addressInfo
     * @return
     */
    public AppResponse addressList(AddressInfo addressInfo){
        List<AddressInfo> addressInfoList = addressDao.addressList(addressInfo);
        return AppResponse.success("查询成功",addressInfoList);
    }

    /**
     * 修改收货地址
     * @param addressInfo
     * @return
     */
    public AppResponse updateAddress(AddressInfo addressInfo){

        addressInfo.setProvince(areaDao.getId(addressInfo.getProvince()));
        addressInfo.setCity(areaDao.getId(addressInfo.getCity()));
        addressInfo.setCounty(areaDao.getId(addressInfo.getCounty()));

        if(addressInfo.getIsDefault().equals("true")) {
            int updateDefault = addressDao.selectDefaultAsFault(addressInfo.getUserId());
            if (updateDefault == 0) {
                return AppResponse.versionError("设置默认失败", "设置默认失败");
            }
        }
        int update = addressDao.updateAddress(addressInfo);
        if(update == 0){
            return AppResponse.versionError("修改失败", "fail");
        }
            return AppResponse.success("修改成功",update);
    }

    /**
     * 查询默认
     * @param userId
     * @return
     */
    public AppResponse selectDefault(String userId){
        AddressInfo addressInfo = addressDao.selectDefault(userId);
        return AppResponse.success("成功",addressInfo);
    }

    /**
     * 根据id查询地址详情
     * @param id
     * @return
     */
    public AppResponse selectAddressById(String id){
        AddressInfo addressInfo = addressDao.selectAddressById(id);
        return AppResponse.success("成功",addressInfo);
    }
}
