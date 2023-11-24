package Application.DataBase.Repository;

import Application.DataBase.Entities.Auth.Credential;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
}
