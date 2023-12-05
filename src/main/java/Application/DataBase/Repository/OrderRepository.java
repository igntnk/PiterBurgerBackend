package Application.DataBase.Repository;

import Application.DataBase.Entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders WHERE user_id LIKE :id " +
            "AND WHERE creation_date > (CURRENT_TIMESTAMP - INTERVAL :days DAY)",
    nativeQuery = true)
    public List<Order> getOrdersByDays(Long id, int days);

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
