package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Band")
@Getter
@Setter
@NoArgsConstructor
public class Band {
    @Id
    @Column(name = "band_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "Band_Product",
            joinColumns =  @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public Band(String name) {
        this.name = name;
    }
}
