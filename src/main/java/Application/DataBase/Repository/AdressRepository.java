package Application.DataBase.Repository;

import Application.DataBase.Entities.Adress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Adress, Long> {
}
