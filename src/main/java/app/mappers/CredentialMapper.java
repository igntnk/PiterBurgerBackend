package app.mappers;

import app.dto.CredentialDTO;
import app.db.Entities.Auth.Credential;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CredentialMapper {
    CredentialDTO toDTO(Credential entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Credential toEntity(CredentialDTO dto);
}
