package app.db.Entities;

import app.db.Entities.Auth.Credential;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name="user_id", updatable = true)
    private Set<Address> adress;

    public User(String FIO) {
        this.FIO = FIO;
    }

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name="user_id", updatable = true)
    private Set<Order> orders;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name="cred_id", referencedColumnName = "cred_id",updatable = true)
    private Credential credential;

    public void addOrder(Order refer){
        orders.add(refer);
    }

}
