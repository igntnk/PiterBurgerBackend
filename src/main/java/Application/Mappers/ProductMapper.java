package Application.Mappers;

import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    public ProductDTO toDTO(Product entity);
}
