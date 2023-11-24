package Application.DataBase.Repository;

import Application.DataBase.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
