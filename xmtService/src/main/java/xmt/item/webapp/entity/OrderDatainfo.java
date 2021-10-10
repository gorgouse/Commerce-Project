package xmt.item.webapp.entity;
import java.util.List;
public class OrderDatainfo {

    private OrderInfo order;

    private List<OrderDetailInfo> orderDetailList;

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }

    public List<OrderDetailInfo> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailInfo> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
