package Application.DataBase.Entities.Auth;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
public class Roles{
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cred_id", referencedColumnName = "cred_id")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.REMOVE})
    private Credential credential;

    @Enumerated(EnumType.STRING)
    private BaseRole role;
}
