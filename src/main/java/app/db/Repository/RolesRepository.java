package app.db.Repository;

import app.db.Entities.Auth.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolesRepository extends CrudRepository<Roles, Long> {

    List<Roles> findAll();
}
