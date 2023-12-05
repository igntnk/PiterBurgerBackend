package Application.Mappers.Resolver;

import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Product;
import Application.DataBase.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver {
    @Autowired
    private ProductRepository productRepository;

    public Product resolve(Long id, Class<Product> type){
        return id != null ? productRepository.findById(id).orElseThrow():new Product();
    }
}
