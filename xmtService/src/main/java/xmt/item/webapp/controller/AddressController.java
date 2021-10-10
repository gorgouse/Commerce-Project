package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.AddressInfo;
import xmt.item.webapp.service.AddressService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    /**
     * 新增收货地址
     * @param addressInfo
     * @return
     */
    @GetMapping("add")
    public AppResponse addAddress(AddressInfo addressInfo){
        return addressService.addAddress(addressInfo);
    }

    /**
     * 收货地址列表
     * @param addressInfo
     * @return
     */
    @GetMapping("/list")
    public AppResponse addressList(AddressInfo addressInfo){
        return addressService.addressList(addressInfo);
    }

    /**
     * 修改收货地址
     * @param addressInfo
     * @return
     */
    @GetMapping("/update")
    public AppResponse updateAddress(AddressInfo addressInfo){
        return addressService.updateAddress(addressInfo);
    }

    /**
     * 查询默认
     * @param userId
     * @return
     */
    @GetMapping("selectDefault")
    public AppResponse selectDefault(String userId){
        return addressService.selectDefault(userId);
    }

    /**
     * 根据id查询地址详情
     * @param id
     * @return
     */
    @GetMapping("/selectAddressById")
    public AppResponse selectAddressById(String id){
        return addressService.selectAddressById(id);
    }

}
