package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.OrderInfo;
import xmt.item.webapp.service.OrderService;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    @GetMapping("/add")
    public AppResponse orderAdd(OrderInfo orderInfo){
        return orderService.orderAdd(orderInfo);
    }

    /**
     * 订单列表
     * @param orderInfo
     * @return
     */
    @GetMapping("/list")
    public AppResponse orderList(OrderInfo orderInfo){
        return orderService.orderList(orderInfo);
    }

    /**
     * 订单详情
     * @param id
     * @return
     */
    @GetMapping("/getOrderById")
    public AppResponse getOrderById(String id){
        return orderService.getOrderById(id);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @GetMapping("/updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo){
        return orderService.updateOrderState(orderInfo);
    }
}
