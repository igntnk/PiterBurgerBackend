package app.db.Entities.Auth;

import javax.persistence.*;

import app.db.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Entity
@Table(name="credential")
@Getter
@Setter
@NoArgsConstructor
public class Credential{
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Credential(boolean enabled, String email, String password,Roles role){
        this.password = passwordEncoder.encode(password);
        this.enabled = enabled;
        this.email = email;
        this.role = role;
    }

    @Id
    @Column(name = "cred_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "credential")
    private User user;


    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name="cred_id", updatable = true)
    private Roles role;

}
