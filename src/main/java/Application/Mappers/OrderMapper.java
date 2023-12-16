package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = OrderItemListMapper.class)
public interface OrderMapper {
    OrderDTO toDTO(Order entity);

    Order toEntity(OrderDTO dto);
}
