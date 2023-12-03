package Application.Mappers;

import Application.DTO.OrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "productId", source = "entity.product.id")
    public OrderItemDTO toDTO(OrderItem entity);
}
