package Application.DataBase.Entities.Auth;

import javax.persistence.*;
import javax.validation.constraints.Email;

import Application.DataBase.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="credential")
@Getter
@Setter
@NoArgsConstructor
public class Credential{
//    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Credential(boolean enabled, String email, String password,Set<Roles> roles){
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


    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="cred_id", updatable = true)
    private Set<Roles> roles;

}
