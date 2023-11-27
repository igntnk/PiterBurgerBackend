package Application.DTO;

import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String comment;
    private Date creationDate;
    private Date onCookingDate;
    private Date onServeDate;
    private Date doneDate;
    private BaseStatus status;

    public static TaskDTO fromEntity(Task refer){
        return new TaskDTO(refer.getId(), refer.getComment(), refer.getCreationDate(),
                refer.getOnCookingDate(),refer.getOnServeDate(),refer.getDoneDate(),refer.getStatus());
    }
}
