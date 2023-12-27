package app.mappers;

import app.dto.UserDTO;
import app.db.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = AddressMapper.class)
public interface UserMapper {
    @Mapping(target = "status", source = "entity.credential.role.role")
    public UserDTO toDTO(User entity);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "credential", ignore = true)
    User toEntity(UserDTO dto);
}
