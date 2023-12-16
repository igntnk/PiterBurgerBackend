package Application.Mappers;

import Application.DTO.SmallDTOs.SmallOrderItemDTO;
import Application.DataBase.Entities.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.function.Function;

@Mapper(componentModel = "spring", uses = SmallOrderItemMapper.class)
public interface SmallOrderItemListMapper {

    List<SmallOrderItemDTO> toDTOList(List<OrderItem> entities);
    List<OrderItem> toListEntity(List<SmallOrderItemDTO> productDTOS);
}
