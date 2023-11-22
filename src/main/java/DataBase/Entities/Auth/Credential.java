package DataBase.Entities.Auth;

import javax.persistence.*;
import javax.validation.constraints.Email;

import DataBase.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Entity
@Table(name="credential")
@Getter
@Setter
@NoArgsConstructor
public class Credential{
//    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Credential(boolean enabled, String email, String password, String name, String surname,Set<Roles> roles){
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.roles = roles;
    }

    @Id
    @Column(name = "cred_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "credential")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Roles> roles;
}
