package app.db.Repository;

import app.db.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = "SELECT * FROM product NATURAL JOIN group_product WHERE group_id = :id AND enabled = true AND name LIKE %:filter%",
        nativeQuery = true)
    public Page<Product> getProductsByGroup(Pageable pageable, @Param("id")Long id,@Param("filter")String filter);

    List<Product> findAll();

}
