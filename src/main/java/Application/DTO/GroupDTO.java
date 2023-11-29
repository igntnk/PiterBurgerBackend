package Application.DTO;

import Application.DataBase.Entities.Group;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDTO {
    private Long id;
    private String name;

    public static GroupDTO fromEntity(Group refer){
        return new GroupDTO(refer.getId(), refer.getName());
    }
}
