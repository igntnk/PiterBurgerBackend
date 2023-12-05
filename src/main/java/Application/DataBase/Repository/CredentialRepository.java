package Application.DataBase.Repository;

import Application.DTO.UserDTO;
import Application.DataBase.Entities.Auth.Credential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
    @Query(
    value = "select cred_id, email, password, enabled, role from credential natural join roles where email LIKE :email",
    nativeQuery = true)
    public Credential getCredByEmail(String email);
}
