package Application.DataBase.Repository;

import Application.DataBase.Entities.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
}
