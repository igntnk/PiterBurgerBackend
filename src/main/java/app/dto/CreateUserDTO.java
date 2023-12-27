package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDTO {
    private String fio;
    private String email;
    private String password;
    private String role;

    CreateUserDTO(){}

}