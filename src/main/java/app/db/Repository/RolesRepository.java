package app.db.Repository;

import app.db.Entities.Auth.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
}
