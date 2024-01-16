package sg.nus.vttp.day24workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import sg.nus.vttp.day24workshop.Utils;
import sg.nus.vttp.day24workshop.models.Order;
import sg.nus.vttp.day24workshop.models.OrderDetail;
import sg.nus.vttp.day24workshop.services.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/")
    public String getLandingPage(Model model){
        model.addAttribute(Utils.ORDER_DETAIL, new OrderDetail());
        return "view0";
    }

    @PostMapping(path = "/order")
    public String getOrder(@ModelAttribute(Utils.ORDER_DETAIL) OrderDetail orderDetail, Model model,
    HttpSession session){
        // String product = mvm.getFirst("product").toString();
        // Float discount = Float.parseFloat(mvm.getFirst("discount").toString());
        // Float unit_price = Float.parseFloat(mvm.getFirst("unit_price").toString());
        // Integer quantity = Integer.parseInt(mvm.getFirst("quantity").toString());
        // String product = orderDetail.getProduct();
        // Float discount = orderDetail.getDiscount();
        // Float unit_price = orderDetail.getUnit_price();
        // Integer quantity = orderDetail.getQuantity();


        // System.out.println(product);
        // System.out.println(discount);
        // System.out.println(unit_price);
        // System.out.println(quantity);

        List<OrderDetail> orderDetailList = Utils.getOrderDetails(session);
        orderDetailList.add(orderDetail);

        model.addAttribute(Utils.ORDER_DETAIL, new OrderDetail());
        return "view0";
    }

    @PostMapping(path = "/checkout")
    public String addOrder(Model model){
        model.addAttribute(Utils.ORDER, new Order());

        return "view1";
    }

    @PostMapping(path = "/process")
    public String processOrder(@ModelAttribute Order order, HttpSession session ){
        try{
            List<OrderDetail> orderDetailList = Utils.getOrderDetails(session);
            order.setOrderDetailList(orderDetailList);
            orderService.processOrder(order);
            return "ok";
        }
        catch(RuntimeException ex){
            return "notok";
        }
        

    }
    
}
