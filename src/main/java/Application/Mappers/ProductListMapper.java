package Application.Mappers;

import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface ProductListMapper {
    public List<ProductDTO> toDTOList(List<Product> entities);
}
