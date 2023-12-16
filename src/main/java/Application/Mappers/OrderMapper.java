package Application.Mappers;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = OrderItemListMapper.class)
public interface OrderMapper {
    OrderDTO toDTO(Order entity);

    @Mapping(target = "id" , source = "dto.id")
    @Mapping(target = "comment" , source = "dto.comment")
    @Mapping(target = "creationDate" , source = "dto.creationDate")
    @Mapping(target = "status" , source = "dto.status")
    @Mapping(target = "items" , source = "dto.items")
    Order toEntity(OrderDTO dto);
}
