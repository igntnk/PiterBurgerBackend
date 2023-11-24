package Application.DataBase.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
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

    @OneToOne(mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.REMOVE})
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User owner;

    @OneToMany(mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.REMOVE})
    private List<OrderItem> items;
}
