package Application.Mappers;

import Application.DTO.GroupDTO;
import Application.DataBase.Entities.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface GroupListMapper {
    public List<GroupDTO> toDTOlist(List<Group> entities);
}
