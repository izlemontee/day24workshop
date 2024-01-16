package sg.nus.vttp.day24workshop.repositories;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.nus.vttp.day24workshop.models.Order;
import sg.nus.vttp.day24workshop.models.OrderDetail;


@Repository
public class OrderRepo {
    @Autowired
    JdbcTemplate template;

    public int addOrder(Order order){
        Date order_date = order.getOrder_date();
        String customer_name = order.getCustomer_name();
        String shipping_address = order.getShipping_address();
        String notes = order.getNotes();
        Float tax = order.getTax();
        return template.update(Queries.SQL_ADD_ORDER, order_date,customer_name,shipping_address,notes);

    }

    public Optional<Integer> getLastOrderId(){
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_RETRIEVE_LAST_ORDER_ID);
        if(rs.next()){
            Integer order_id = rs.getInt("order_id");
            return Optional.of(order_id);
        }

        return Optional.empty();

    }

    public int addOrderDetails(OrderDetail orderDetail, Integer order_id){
        String product = orderDetail.getProduct();
        Float unit_price = orderDetail.getUnit_price();
        Float discount = orderDetail.getDiscount();
        Integer quantity = orderDetail.getQuantity();
        return template.update(Queries.SQL_ADD_ORDER_DETAILS, product, unit_price, discount, quantity, order_id);
    }
    
}
