package app.db.Repository;

import app.db.Entities.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAll();
}
