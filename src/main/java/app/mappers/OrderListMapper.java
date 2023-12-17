package app.mappers;

import app.dto.OrderDTO;
import app.db.Entities.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface OrderListMapper {
    public List<OrderDTO> toDTOList(List<Order> entities);

    List<Order> toListEntity(List<OrderDTO> orderDTOS);
}
