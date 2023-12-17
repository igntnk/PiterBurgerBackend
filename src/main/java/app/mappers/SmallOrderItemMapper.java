package app.mappers;

import app.dto.small.SmallOrderItemDTO;
import app.db.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SmallProductMapper.class)
public interface SmallOrderItemMapper {

    SmallOrderItemDTO toDTO(OrderItem entity);

    @Mapping(target = "id", ignore = true)
    OrderItem toEntity(SmallOrderItemDTO entity);

}
