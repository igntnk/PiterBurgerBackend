package Application.DTO;

import Application.DataBase.Entities.Band;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BandDTO {
    private Long id;
    private String name;

    public static BandDTO fromEntity(Band refer){
        return new BandDTO(refer.getId(), refer.getName());
    }
}
