package app.db.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;
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
    private OffsetDateTime creationDate;

    @Column(name = "on_cook_date")
    private OffsetDateTime onCookingDate;

    @Column(name = "on_serve_date")
    private OffsetDateTime onServeDate;

    @Column(name = "done_date")
    private OffsetDateTime doneDate;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name="order_id", updatable = true)
    private Set<OrderItem> items;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id",updatable = true,nullable = false)
    private User user;


    public Order(String comment, OffsetDateTime creationDate,
                BaseStatus status, Set<OrderItem> items) {
        this.comment = comment;
        this.creationDate = creationDate;
        this.status = status;
        this.items = items;
    }
}
