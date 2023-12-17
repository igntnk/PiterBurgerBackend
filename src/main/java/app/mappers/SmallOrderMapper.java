package app.mappers;

import app.dto.small.SmallOrderDTO;
import app.db.Entities.BaseStatus;
import app.db.Entities.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring",uses = {SmallOrderItemMapper.class})
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
