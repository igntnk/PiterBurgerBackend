package Application.Mappers;

import Application.DTO.GroupDTO;
import Application.DataBase.Entities.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    public GroupDTO toDTO(Group entity);
}
