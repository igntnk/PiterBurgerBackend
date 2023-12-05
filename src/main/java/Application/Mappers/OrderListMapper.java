package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface OrderListMapper {
    public List<OrderDTO> toDTOList(List<Order> entities);
}
