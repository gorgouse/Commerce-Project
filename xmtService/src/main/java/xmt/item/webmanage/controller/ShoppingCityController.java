package xmt.item.webmanage.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webmanage.entity.ClassifyInfo;
import xmt.item.webmanage.entity.ClientInfo;
import xmt.item.webmanage.entity.OrderManageInfo;
import xmt.item.webmanage.service.ShoppingCityService;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/shoppingCity")
public class ShoppingCityController {

    @Resource
    private ShoppingCityService shoppingCityService;

    /**
     * 获取一二级分类
     * @return
     */
    @GetMapping("allClassify")
    public AppResponse sortSelect(){
        return shoppingCityService.getAllSort();
    }

    /**
     * 新增分类
     * @param classifyInfo
     * @return
     */
    @GetMapping("addClassify")
    public AppResponse addClassify(ClassifyInfo classifyInfo){
        return shoppingCityService.addClassify(classifyInfo);
    }

    /**
     * 修改分类
     * @param classifyInfo
     * @return
     */
    @GetMapping("updateClassify")
    public AppResponse updateClassify(ClassifyInfo classifyInfo){
        return shoppingCityService.updateClassify(classifyInfo);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @GetMapping("deleteClassify")
    public AppResponse deleteClassify(String id){
        return shoppingCityService.deleteClassify(id);
    }

    /**
     * 查询订单
     * @param orderManageInfo
     * @return
     */
    @GetMapping("/selectOrder")
    public AppResponse selectOrder(OrderManageInfo orderManageInfo){
        return shoppingCityService.selectOrder(orderManageInfo);
    }

    /**
     *
     * @param clientInfo
     * @return
     */
    @GetMapping("/selectClient")
    public AppResponse selectClient(ClientInfo clientInfo){
        return shoppingCityService.selectClient(clientInfo);
    }

}
