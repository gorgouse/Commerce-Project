package xmt.item.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import xmt.item.webapp.entity.OrderDetailInfo;
import xmt.item.webapp.entity.OrderInfo;
import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    int orderAdd(OrderInfo orderInfo);

    /**
     * 新增订单详情
     * @param orderDetailInfo
     * @return
     */
    int orderDetailAdd(OrderDetailInfo orderDetailInfo);

    /**
     * 查询订单
     * @param orderInfo
     * @return
     */
    List<OrderInfo> orderList(OrderInfo orderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailInfo> orderDetailList(String orderId);

    /**
     * 通过id查询订单
     * @param id
     * @return
     */
    OrderInfo getOrderById(String id);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderState(OrderInfo orderInfo);
}
