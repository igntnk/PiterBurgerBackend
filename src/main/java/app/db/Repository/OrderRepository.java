package app.db.Repository;

import app.db.Entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
            "WHERE email LIKE :email AND status NOT LIKE 'DONE'",
    nativeQuery = true)
    public List<Order> getActiveOrders(String email);

    @Query(value = "SELECT * FROM orders WHERE status NOT LIKE 'DONE'",
            nativeQuery = true)
    public List<Order> getManagerOrders();

    @Query(value = "SELECT * FROM orders WHERE status NOT LIKE 'DONE' AND status NOT LIKE 'SERVED' AND status NOT LIKE 'FREEZE'",
            nativeQuery = true)
    public List<Order> getWorkerOrders();

}
