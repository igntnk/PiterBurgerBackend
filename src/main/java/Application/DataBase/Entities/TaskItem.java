package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "task_item")
@Getter
@Setter
@NoArgsConstructor
public class TaskItem {
    @Id
    @Column(name = "task_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count")
    private int count;

    @ManyToOne()
    @JoinColumn(name = "product_id",referencedColumnName = "product_id",updatable = true)
    private Product product;

    public TaskItem(int count,Product product) {
        this.count = count;
        this.product = product;
    }
}
