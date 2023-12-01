package Application.DTO;

import Application.DataBase.Entities.Auth.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTO {
    private String username;
    private String password;
    private boolean enabled;

    public static CredentialDTO fromEntity(Credential refer){
        return new CredentialDTO(refer.getEmail(), refer.getPassword(), refer.isEnabled());
    }
}
