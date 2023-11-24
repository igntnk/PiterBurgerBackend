package Application.DataBase.Entities;

import Application.DataBase.Entities.Auth.Credential;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio")
    private String FIO;

    @OneToMany(mappedBy = "owner")
    private List<Adress> adress;

    public User(String FIO) {
        this.FIO = FIO;
    }

    @OneToMany(mappedBy = "owner")
    private List<Task> tasks;

    @OneToOne(mappedBy = "user")
    private Credential credential;

}
