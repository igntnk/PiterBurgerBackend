package app.db.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Address(boolean active, String address) {
        this.active = active;
        this.address = address;
    }

    @Column(name = "active")
    private boolean active;

    @Column(name = "address")
    private String address;

}
