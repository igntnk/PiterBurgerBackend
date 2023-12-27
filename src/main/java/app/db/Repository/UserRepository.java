package app.db.Repository;

import app.db.Entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(
            value = "SELECT * FROM users NATURAL JOIN credential WHERE email = :email",
            nativeQuery = true)
    User getUserByEmail(@Param("email") String email);


    @Query(
            value = "SELECT user_id, fio, cred_id FROM users NATURAL JOIN credential WHERE enabled = true AND role_id != 1;",
            nativeQuery = true
    )
    List<User> getAllEnabledUsers();

}
