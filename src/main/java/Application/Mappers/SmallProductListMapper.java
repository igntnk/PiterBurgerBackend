package Application.Mappers;

import Application.DTO.SmallDTOs.SmallProductDTO;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SmallProductMapper.class)
public interface SmallProductListMapper {

    List<SmallProductDTO> toDTOList(List<Product> entities);

    List<Product> toListEntity(List<SmallProductDTO> productDTOS);
}
