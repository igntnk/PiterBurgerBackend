package Application.DTO;

import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String comment;
    private Date creationDate;
    private Date onCookingDate;
    private Date onServeDate;
    private Date doneDate;
    private BaseStatus status;

    public static OrderDTO fromEntity(Order refer){
        return new OrderDTO(refer.getId(), refer.getComment(), refer.getCreationDate(),
                refer.getOnCookingDate(),refer.getOnServeDate(),refer.getDoneDate(),refer.getStatus());
    }
}
