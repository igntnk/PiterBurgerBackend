package Application.DataBase.Repository;

import Application.DataBase.Entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query(value = "SELECT * FROM task WHERE user_id LIKE :id " +
            "AND WHERE creation_date > (CURRENT_TIMESTAMP - INTERVAL :days DAY)",
    nativeQuery = true)
    public ArrayList<Task> getOrdersByDays(Long id, int days);

}
