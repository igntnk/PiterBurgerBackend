package app.dto.small;

import lombok.Data;

@Data
public class SmallOrderItemDTO {
    private int count;
    private SmallProductDTO product;
}
