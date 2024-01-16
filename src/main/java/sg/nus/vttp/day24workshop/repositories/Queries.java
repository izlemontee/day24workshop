package sg.nus.vttp.day24workshop.repositories;

public class Queries {

    public static final String SQL_ADD_ORDER="""
            INSERT into ORDERS (order_date, customer_name, ship_address, notes)
            VALUES(?, ?, ?, ?);
            """;

    public static final String SQL_ADD_ORDER_DETAILS="""
            INSERT into ORDER_DETAILS (product, unit_price, discount, quantity, order_id)
            VALUES(?, ?, ?, ?, ?);
            
            """;

    public static final String SQL_RETRIEVE_LAST_ORDER_ID="""
            SELECT order_id 
            FROM orders
            ORDER BY order_id desc
            limit 1;    
            """;
    
}
