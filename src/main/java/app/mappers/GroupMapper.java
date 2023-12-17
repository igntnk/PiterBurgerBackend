package app.mappers;

import app.dto.GroupDTO;
import app.db.Entities.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO toDTO(Group entity);

    @Mapping(target = "products", ignore = true)
    Group toEntity(GroupDTO dto);
}
