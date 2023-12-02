package Application.Mappers;

import Application.DTO.CredentialDTO;
import Application.DataBase.Entities.Auth.Credential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialMapper {
    CredentialDTO toDTO(Credential entity);
}
