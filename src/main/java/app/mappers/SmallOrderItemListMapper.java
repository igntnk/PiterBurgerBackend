package app.mappers;

import app.dto.small.SmallOrderItemDTO;
import app.db.Entities.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SmallOrderItemMapper.class)
public interface SmallOrderItemListMapper {

    List<SmallOrderItemDTO> toDTOList(List<OrderItem> entities);
    List<OrderItem> toListEntity(List<SmallOrderItemDTO> productDTOS);
}
