package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class Task {
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

    @OneToOne(mappedBy = "task")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User owner;

    @OneToMany(mappedBy = "task")
    private List<TaskItem> items;
}
