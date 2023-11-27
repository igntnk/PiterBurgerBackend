package Application.DTO;

import Application.DataBase.Entities.TaskItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskItemDTO {
    private Long id;
    private int count;
    private Long product;

    public static TaskItemDTO fromEntity(TaskItem refer){
        return new TaskItemDTO(refer.getId(), refer.getCount(),refer.getProduct().getId());
    }
}
