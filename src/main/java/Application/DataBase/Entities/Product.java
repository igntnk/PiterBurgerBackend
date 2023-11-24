package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @OneToOne(mappedBy = "product" )
    private TaskItem orderItem;

    @ManyToMany(mappedBy = "products")
    private List<Band> groups;
}
