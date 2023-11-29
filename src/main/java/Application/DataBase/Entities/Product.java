package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderItem> orderItem;

    @ManyToMany(mappedBy = "products")
    private Set<Group> groups;

    public Product(String name, String description, int price, boolean enabled) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.enabled = enabled;
    }
}
