package Application.DTO;

import Application.DataBase.Entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapper;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    private int count;
    private ProductDTO product;
}
