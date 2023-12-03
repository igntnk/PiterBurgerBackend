package Application.DataBase.Repository;

import Application.DataBase.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM product NATURAL JOIN group_product WHERE group_id = :id AND enabled = true",
        nativeQuery = true)
    public List<Product> getProductsByGroup(@Param("id")Long id);

    List<Product> findAll();

}
