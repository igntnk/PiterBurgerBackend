package Application.Mappers;

import Application.DTO.GroupDTO;
import Application.DataBase.Entities.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO toDTO(Group entity);

    Group toEntity(GroupDTO dto);
}
