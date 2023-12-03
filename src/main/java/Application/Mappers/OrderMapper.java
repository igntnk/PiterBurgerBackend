package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = OrderItemMapper.class)
public interface OrderMapper {
    public OrderDTO toDTO(Order entity);
}
