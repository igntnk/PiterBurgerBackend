package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDTO {
    private String FIO;
    private String role;
    private String password;
    private String email;
}