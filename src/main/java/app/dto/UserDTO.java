package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String FIO;
    private List<AddressDTO> adress;
}
