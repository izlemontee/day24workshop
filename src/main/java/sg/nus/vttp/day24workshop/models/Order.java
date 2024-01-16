package sg.nus.vttp.day24workshop.models;

import java.sql.Date;
import java.util.List;

public class Order {
    private Integer order_id;
    private Date order_date;
    private String customer_name;
    private String shipping_address;
    private String notes;
    private Float tax;

    private List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }
    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    public Order(){

    }
    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getShipping_address() {
        return shipping_address;
    }
    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Float getTax() {
        return tax;
    }
    public void setTax(Float tax) {
        this.tax = tax;
    }
    public Order(Date order_date, String customer_name, String shipping_address, String notes, Float tax) {
        this.order_date = order_date;
        this.customer_name = customer_name;
        this.shipping_address = shipping_address;
        this.notes = notes;
        this.tax = tax;
    }
    
}
