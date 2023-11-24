package Application.DataBase.Repository;

import Application.DataBase.Entities.Auth.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
}
