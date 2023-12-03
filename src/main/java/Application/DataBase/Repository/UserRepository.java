package Application.DataBase.Repository;

import Application.DTO.UserDTO;
import Application.DataBase.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(
            value = "SELECT * FROM users NATURAL JOIN credential WHERE email LIKE :email",
            nativeQuery = true)
    public User getUserByEmail(@Param("email") String email);
}
