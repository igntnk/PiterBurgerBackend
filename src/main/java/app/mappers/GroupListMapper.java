package app.mappers;

import app.dto.GroupDTO;
import app.db.Entities.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface GroupListMapper {
    public List<GroupDTO> toDTOlist(List<Group> entities);

    List<Group> toListEntity(List<GroupDTO> groupDTOS);
}
