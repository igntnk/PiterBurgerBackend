package Application.DTO.SmallDTOs;

import Application.DTO.ProductDTO;
import lombok.Data;

@Data
public class SmallOrderItemDTO {
    private int count;
    private SmallProductDTO product;
}
