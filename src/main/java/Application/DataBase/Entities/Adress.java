package Application.DataBase.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adress")
@Getter
@Setter
public class Adress {
    @Id
    @Column(name = "adress_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Adress(boolean active, User owner) {
        this.active = active;
        this.owner = owner;
    }

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User owner;
}
