package app.mappers;

import app.db.Entities.OrderItem;
import app.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface OrderItemMapper {
    OrderItemDTO toDTO(OrderItem entity);

    @Mapping(target = "id", ignore = true)
    OrderItem toEntity(OrderItemDTO dto);
}
