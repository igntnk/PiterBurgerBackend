package app.mappers;

import app.dto.CredentialDTO;
import app.db.Entities.Auth.Credential;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = CredentialMapper.class)
public interface CredentialListMapper {
    public List<CredentialDTO> toDTOlist(List<Credential> entities);

    List<Credential> toListEntity(List<CredentialDTO> credentialDTOS);
}
