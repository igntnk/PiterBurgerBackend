package Application.DataBase.Repository;

import Application.DataBase.Entities.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
