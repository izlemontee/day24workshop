package sg.nus.vttp.day24workshop.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.vttp.day24workshop.models.Order;
import sg.nus.vttp.day24workshop.models.OrderDetail;
import sg.nus.vttp.day24workshop.repositories.OrderRepo;


@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Integer getOrderId(){
        Optional<Integer> order_id_optional = orderRepo.getLastOrderId();
        if(order_id_optional.isPresent()){
            return order_id_optional.get();
        }
        return null;
    }

    @Transactional
    public void processOrder(Order order){
        int orderIn = orderRepo.addOrder(order);
        Integer order_id = getOrderId();
        List<OrderDetail> orderDetailList = order.getOrderDetailList();
        int counter = 0;
        if(null != orderDetailList){
            for(OrderDetail od:orderDetailList){
               counter += orderRepo.addOrderDetails(od, order_id);
            }
        }
        boolean allOrderDetailssAdded = (counter == orderDetailList.size());
        boolean orderAdded = (orderIn > 0);
        if(!(orderAdded&&allOrderDetailssAdded)){
            throw new RuntimeErrorException(null);
        }
    }    
    
}
