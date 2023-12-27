package app.db.Entities;

import app.db.Entities.Auth.Credential;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    private Set<Address> address;

    @OneToMany(orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name="user_id", updatable = true)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Set<Order> orders;

    @OneToOne(orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name="cred_id", referencedColumnName = "cred_id",updatable = true)
    private Credential credential;

    public User(String FIO) {
        this.FIO = FIO;
    }

    public void addOrder(Order refer){
        orders.add(refer);
    }

}
