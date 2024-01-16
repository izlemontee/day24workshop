package sg.nus.vttp.day24workshop.models;

public class OrderDetail {

    private Integer id;
    private String product;
    private Float unit_price;
    private Float discount;
    private Integer quantity;
    private Integer order_id;

    public OrderDetail(){

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Float getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }
    public Float getDiscount() {
        return discount;
    }
    public void setDiscount(Float discount) {
        this.discount = discount;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public OrderDetail(Integer id, String product, Float unit_price, Float discount, Integer quantity) {
        this.id = id;
        this.product = product;
        this.unit_price = unit_price;
        this.discount = discount;
        this.quantity = quantity;
    }
    
}
