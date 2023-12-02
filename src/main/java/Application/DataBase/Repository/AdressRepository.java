package Application.DataBase.Repository;

import Application.DataBase.Entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Address, Long> {
}
