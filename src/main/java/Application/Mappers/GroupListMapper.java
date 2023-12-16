package Application.Mappers;

import Application.DTO.CredentialDTO;
import Application.DTO.GroupDTO;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface GroupListMapper {
    public List<GroupDTO> toDTOlist(List<Group> entities);

    List<Group> toListEntity(List<GroupDTO> groupDTOS);
}
