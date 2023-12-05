package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Order;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = OrderItemMapper.class)
public interface OrderMapper {
    public OrderDTO toDTO(Order entity);
}
