package Application.Mappers;

import Application.DTO.AddressDTO;
import Application.DataBase.Entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO toDTO(Address entity);

    Address toEntity(AddressDTO dto);
}
