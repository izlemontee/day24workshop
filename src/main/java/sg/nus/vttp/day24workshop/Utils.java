package sg.nus.vttp.day24workshop;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import sg.nus.vttp.day24workshop.models.Order;
import sg.nus.vttp.day24workshop.models.OrderDetail;

public class Utils {

    public static final String ORDER = "order";
    public static final String ORDER_DETAIL = "orderdetail";

    public Order getOrder(HttpSession session){
        Object orderObject = session.getAttribute(ORDER);
        if(null == orderObject){
            Order order = new Order();
            session.setAttribute(ORDER, order);
            return order;
        }
        return (Order) orderObject;
    }

    public static List<OrderDetail> getOrderDetails(HttpSession session){
        Object orderDetailListObject = session.getAttribute(ORDER_DETAIL);
        if(orderDetailListObject == null){
            List<OrderDetail> orderDetailList = new ArrayList<>();
            session.setAttribute(ORDER_DETAIL, orderDetailList);
            return orderDetailList;
        }
        return (List<OrderDetail>)orderDetailListObject;

    }
    
}
