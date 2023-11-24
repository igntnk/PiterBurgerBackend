package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name= "task_id", referencedColumnName = "task_id")
    private Task task;
}
