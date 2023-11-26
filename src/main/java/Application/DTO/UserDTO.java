package Application.DTO;

import Application.DataBase.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String FIO;
    private String email;
    private List<AddressDTO> addressList;

    public static UserDTO fromEntity(User refer){
        return new UserDTO(refer.getId(),refer.getFIO(),refer.getCredential().getEmail(),
                refer.getAdress().isEmpty()?null:
                        refer.getAdress().stream().map(AddressDTO::fromEntity).collect(Collectors.toList()));
    }
}
