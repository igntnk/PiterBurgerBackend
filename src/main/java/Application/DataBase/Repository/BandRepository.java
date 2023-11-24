package Application.DataBase.Repository;

import Application.DataBase.Entities.Band;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {
}
