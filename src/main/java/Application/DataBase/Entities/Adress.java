package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adress")
@Getter
@Setter
@NoArgsConstructor
public class Adress {
    @Id
    @Column(name = "adress_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Adress(boolean active, String address) {
        this.active = active;
        this.address = address;
    }

    @Column(name = "active")
    private boolean active;

    @Column(name = "adress")
    private String address;

}
