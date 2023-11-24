package Application.DataBase.Repository;

import Application.DataBase.Entities.TaskItem;
import org.springframework.data.repository.CrudRepository;

public interface TaskItemRepository extends CrudRepository<TaskItem, Long> {
}
