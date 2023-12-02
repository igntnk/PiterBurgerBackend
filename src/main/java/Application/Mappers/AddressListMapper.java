package Application.Mappers;

import Application.DTO.AddressDTO;
import Application.DataBase.Entities.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface AddressListMapper {
    List<AddressDTO> toDTOList(List<Address> addresses);
}
