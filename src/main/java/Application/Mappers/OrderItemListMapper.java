package Application.Mappers;

import Application.DTO.OrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderItemListMapper {
    @Mapping(target = "productId", source = "entity.product.id")
    public List<OrderItemDTO> toDTOList(List<OrderItem> entities);
}
