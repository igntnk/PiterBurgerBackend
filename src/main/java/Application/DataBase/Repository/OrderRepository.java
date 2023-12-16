package Application.DataBase.Repository;

import Application.DataBase.Entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT order_id,comment,creation_date,done_date,on_cook_date," +
            "on_serve_date,status,user_id FROM users " +
            "NATURAL JOIN credential NATURAL JOIN orders " +
            "WHERE email LIKE :email AND creation_date > (NOW() - INTERVAL '7' DAY);",
    nativeQuery = true)
    public List<Order> getHistory(String email);

    @Query(value = "SELECT order_id,comment,creation_date,done_date,on_cook_date," +
            "on_serve_date,status,user_id FROM users " +
            "NATURAL JOIN credential NATURAL JOIN orders " +
            "WHERE email LIKE :email AND status NOT LIKE 'DONE' AND status NOT LIKE 'FREEZE'",
    nativeQuery = true)
    public List<Order> getActiveOrders(String email);

    @Query(value = "SELECT * FROM orders WHERE status NOT LIKE 'DONE'",
    nativeQuery = true)
    public List<Order> getAllActiveOrder();

    @Query(value = "SELECT * FROM orders WHERE status LIKE 'ACTIVE' or status LIKE 'COOKING'",
    nativeQuery = true)
    public List<Order> getKitchenOrders();

    @Query(value = "SELECT * FROM orders WHERE status LIKE 'COOKED' or status LIKE 'SERVING'",
            nativeQuery = true)
    public List<Order> getCounterOrders();

    @Query(value = "SELECT * FROM orders WHERE status NOT LIKE 'FREEZE' or status NOT LIKE 'DONE'",
            nativeQuery = true)
    public List<Order> getManagerOrders();

    @Query(value = "SELECT * FROM orders WHERE status NOT LIKE 'DONE'",
            nativeQuery = true)
    public List<Order> getUndoneOrders();

}
