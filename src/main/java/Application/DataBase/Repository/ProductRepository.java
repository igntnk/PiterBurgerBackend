package Application.DataBase.Repository;

import Application.DataBase.Entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
