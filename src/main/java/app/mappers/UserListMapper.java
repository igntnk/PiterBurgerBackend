package app.mappers;

import app.dto.UserDTO;
import app.db.Entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface UserListMapper {
    public List<UserDTO> toDTOList(List<User> entities);

    List<User> toListEntity(List<UserDTO> userDTOS);
}
