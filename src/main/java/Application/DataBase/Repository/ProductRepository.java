package Application.DataBase.Repository;

import Application.DataBase.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p NATURAL JOIN band_product WHERE p.band_id = :id",
        nativeQuery = true)
    public List<Product> getProductsByGroup(Long id);

    List<Product> findAll();

}
