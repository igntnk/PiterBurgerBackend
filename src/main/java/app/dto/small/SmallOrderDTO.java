package app.dto.small;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmallOrderDTO {
    private String comment;
    private List<SmallOrderItemDTO> items;
}