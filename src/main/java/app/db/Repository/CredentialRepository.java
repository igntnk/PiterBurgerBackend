package app.db.Repository;

import app.db.Entities.Auth.Credential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
    @Query(
    value = "select cred_id, email, password, enabled, role from credential natural join roles where email LIKE :email",
    nativeQuery = true)
    public Credential getCredByEmail(String email);
}
