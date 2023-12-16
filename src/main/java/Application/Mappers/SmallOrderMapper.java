package Application.Mappers;

import Application.DTO.SmallDTOs.SmallOrderDTO;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring",uses = SmallOrderItemListMapper.class)
public interface SmallOrderMapper {

    @Mapping(target = "comment", source = "entity.comment")
    @Mapping(target = "items", source = "entity.items")
    SmallOrderDTO toDTO(Order entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "onCookingDate", ignore = true)
    @Mapping(target = "onServeDate", ignore = true)
    @Mapping(target = "doneDate", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "creationDate", expression = "java(java.time.OffsetDateTime.now())" )
    @Mapping(target = "status", constant  = "ACTIVE" )
    Order toEntity(SmallOrderDTO dto);

    @AfterMapping
    default void setStatus(@MappingTarget Order entity){
        entity.setStatus(BaseStatus.ACTIVE);
    }

    @AfterMapping
    default void setCreationDate(@MappingTarget Order entity){
        entity.setCreationDate(OffsetDateTime.now());
    }
}
