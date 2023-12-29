package app.dto.small;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmallOrderItemDTO {
    private int count;
    private SmallProductDTO product;
}
