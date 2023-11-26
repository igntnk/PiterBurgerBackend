package Application.DTO;

import Application.DataBase.Entities.Adress;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private boolean active;
    private String address;

    public static AddressDTO fromEntity(Adress refer){
        return new AddressDTO(refer.getId(), refer.isActive(), refer.getAddress());
    }
}
