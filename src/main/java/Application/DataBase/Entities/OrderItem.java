package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count")
    private int count;

    @ManyToOne()
    @JoinColumn(name = "product_id",referencedColumnName = "product_id",updatable = true)
    private Product product;

    public OrderItem(int count,Product product) {
        this.count = count;
        this.product = product;
    }
}
