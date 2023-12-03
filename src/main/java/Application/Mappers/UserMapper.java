package Application.Mappers;

import Application.DTO.UserDTO;
import Application.DataBase.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = AddressMapper.class)
public interface UserMapper {
    public UserDTO toDTO(User entity);
}
