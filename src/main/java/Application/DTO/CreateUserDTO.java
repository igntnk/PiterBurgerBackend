package Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateUserDTO {
    private String FIO;
    private String role;
    private String password;
    private String email;
}