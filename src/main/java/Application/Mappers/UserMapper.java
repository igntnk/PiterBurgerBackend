package Application.Mappers;

import Application.DTO.UserDTO;
import Application.DataBase.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserDTO toDTO(User entity);
}
