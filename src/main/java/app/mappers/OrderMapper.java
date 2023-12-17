package app.mappers;

import app.dto.OrderDTO;
import app.db.Entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {OrderItemMapper.class, ProductMapper.class})
public interface OrderMapper {
    OrderDTO toDTO(Order entity);

    @Mapping(target = "onCookingDate", ignore = true)
    @Mapping(target = "onServeDate", ignore = true)
    @Mapping(target = "doneDate", ignore = true)
    @Mapping(target = "user", ignore = true)
    Order toEntity(OrderDTO dto);
}
