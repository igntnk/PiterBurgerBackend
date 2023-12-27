package app.db.Repository;

import app.db.Entities.Auth.Credential;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
    @Query(
    value = "select cred_id, email, password, enabled, role from credential natural join roles where email LIKE :email",
    nativeQuery = true)
    public Credential getCredByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE credential SET enabled = false WHERE cred_id = :id",
            nativeQuery = true)
    void disableUserById(@Param("id")Long id);
}
