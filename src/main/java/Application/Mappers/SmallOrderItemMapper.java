package Application.Mappers;

import Application.DTO.SmallDTOs.SmallOrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface SmallOrderItemMapper {

    SmallOrderItemDTO toDTO(OrderItem entity);

    OrderItem toEntity(SmallOrderItemDTO entity);

}
