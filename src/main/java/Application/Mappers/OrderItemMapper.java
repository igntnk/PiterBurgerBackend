package Application.Mappers;

import Application.DTO.OrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface OrderItemMapper {
    @Mapping(target = "product",source = "entity.product")
    OrderItemDTO toDTO(OrderItem entity);

    @Mapping(target = "product" , source = "dto.product")
    OrderItem toEntity(OrderItemDTO dto);
}
