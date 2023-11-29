package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "on_cook_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date onCookingDate;

    @Column(name = "on_serve_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date onServeDate;

    @Column(name = "done_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneDate;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="task_id", updatable = true)
    private Set<OrderItem> items;


    public Order(String comment, Date creationDate,
                BaseStatus status, Set<OrderItem> items) {
        this.comment = comment;
        this.creationDate = creationDate;
        this.status = status;
        this.items = items;
    }
}
