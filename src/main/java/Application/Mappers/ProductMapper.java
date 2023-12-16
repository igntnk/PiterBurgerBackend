package Application.Mappers;

import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product entity);

    Product toEntity(ProductDTO dto);
}
