package app.mappers;

import app.dto.AddressDTO;
import app.db.Entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO toDTO(Address entity);

    Address toEntity(AddressDTO dto);
}
