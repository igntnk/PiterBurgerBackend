package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DTO.ProductDTO;
import Application.DataBase.Entities.Order;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface ProductListMapper {
    List<ProductDTO> toDTOList(List<Product> entities);

    List<Product> toListEntity(List<ProductDTO> productDTOS);
}
