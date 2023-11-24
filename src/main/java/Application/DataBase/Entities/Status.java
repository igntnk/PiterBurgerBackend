package Application.DataBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
public class Status {

    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;
}
