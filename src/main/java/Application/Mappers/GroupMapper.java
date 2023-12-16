package Application.Mappers;

import Application.DTO.GroupDTO;
import Application.DataBase.Entities.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO toDTO(Group entity);

    @Mapping(target = "products", ignore = true)
    Group toEntity(GroupDTO dto);
}
