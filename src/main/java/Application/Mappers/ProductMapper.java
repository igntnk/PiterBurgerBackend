package Application.Mappers;

import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product entity);

    @Mapping(target = "orderItem", ignore = true)
    @Mapping(target = "groups", ignore = true)
    Product toEntity(ProductDTO dto);
}
