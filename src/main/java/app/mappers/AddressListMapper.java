package app.mappers;

import app.dto.AddressDTO;
import app.db.Entities.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface AddressListMapper {
    List<AddressDTO> toDTOList(List<Address> addresses);

    List<Address> toListEntity(List<AddressDTO> addressDTOS);
}
