package app.mappers;

import app.dto.OrderItemDTO;
import app.db.Entities.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderItemListMapper {
    public List<OrderItemDTO> toDTOList(List<OrderItem> entities);

    List<OrderItem> toListEntity(List<OrderItemDTO> orderItemDTOS);
}
