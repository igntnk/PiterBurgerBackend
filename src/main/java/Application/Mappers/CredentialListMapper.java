package Application.Mappers;

import Application.DTO.AddressDTO;
import Application.DTO.CredentialDTO;
import Application.DataBase.Entities.Address;
import Application.DataBase.Entities.Auth.Credential;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = CredentialMapper.class)
public interface CredentialListMapper {
    public List<CredentialDTO> toDTOlist(List<Credential> entities);

    List<Credential> toListEntity(List<CredentialDTO> credentialDTOS);
}
