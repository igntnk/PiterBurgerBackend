package Application.Mappers;

import Application.DTO.OrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface OrderItemMapper {
    OrderItemDTO toDTO(OrderItem entity);

    @Mapping(target = "id", ignore = true)
    OrderItem toEntity(OrderItemDTO dto);
}
