package Application.DataBase.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group")
@Getter
@Setter
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "Group_Product",
            joinColumns =  @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
