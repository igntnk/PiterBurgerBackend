package Application.DTO;

import Application.DataBase.Entities.Auth.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTO {
    private String email;
    private String password;
    private boolean enabled;
}
