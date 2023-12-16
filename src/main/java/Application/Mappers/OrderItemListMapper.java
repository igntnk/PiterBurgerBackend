package Application.Mappers;

import Application.DTO.GroupDTO;
import Application.DTO.OrderItemDTO;
import Application.DataBase.Entities.Group;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderItemListMapper {
    public List<OrderItemDTO> toDTOList(List<OrderItem> entities);

    List<OrderItem> toListEntity(List<OrderItemDTO> orderItemDTOS);
}
