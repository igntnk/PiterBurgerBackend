package Application.DataBase.Repository;

import Application.DataBase.Entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
