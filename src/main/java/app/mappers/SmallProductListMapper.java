package app.mappers;

import app.dto.small.SmallProductDTO;
import app.db.Entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SmallProductMapper.class)
public interface SmallProductListMapper {

    List<SmallProductDTO> toDTOList(List<Product> entities);

    List<Product> toListEntity(List<SmallProductDTO> productDTOS);
}
