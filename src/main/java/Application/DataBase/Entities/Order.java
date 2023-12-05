package Application.DataBase.Entities;

import Application.DTO.OrderItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
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
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name="order_id", updatable = true)
    private Set<OrderItem> items;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",updatable = true)
    private User user;


    public Order(String comment, Date creationDate,
                BaseStatus status, Set<OrderItem> items) {
        this.comment = comment;
        this.creationDate = creationDate;
        this.status = status;
        this.items = items;
    }
}
