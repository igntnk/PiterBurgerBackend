package Application.Mappers;

import Application.DTO.SmallDTOs.SmallOrderItemDTO;
import Application.DTO.SmallDTOs.SmallProductDTO;
import Application.DataBase.Entities.OrderItem;
import Application.DataBase.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SmallProductMapper {

    SmallProductDTO toDTO(Product entity);

    @Mapping(target = "name",ignore = true)
    @Mapping(target = "description",ignore = true)
    @Mapping(target = "price",ignore = true)
    @Mapping(target = "enabled",ignore = true)
    @Mapping(target = "photo",ignore = true)
    @Mapping(target = "orderItem",ignore = true)
    @Mapping(target = "groups",ignore = true)
    Product toEntity(SmallProductDTO entity);

}
