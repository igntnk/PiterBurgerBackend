package Application.Mappers;

import Application.DTO.ProductDTO;
import Application.DTO.UserDTO;
import Application.DataBase.Entities.Product;
import Application.DataBase.Entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface UserListMapper {
    public List<UserDTO> toDTOList(List<User> entities);

    List<User> toListEntity(List<UserDTO> userDTOS);
}
