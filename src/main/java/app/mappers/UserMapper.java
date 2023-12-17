package app.mappers;

import app.dto.UserDTO;
import app.db.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = AddressMapper.class)
public interface UserMapper {
    public UserDTO toDTO(User entity);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "credential", ignore = true)
    User toEntity(UserDTO dto);
}
