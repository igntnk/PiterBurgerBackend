package app.mappers;

import app.dto.ProductDTO;
import app.db.Entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface ProductListMapper {
    List<ProductDTO> toDTOList(List<Product> entities);

    List<Product> toListEntity(List<ProductDTO> productDTOS);
}
