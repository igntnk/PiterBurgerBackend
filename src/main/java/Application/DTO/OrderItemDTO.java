package Application.DTO;

import Application.DataBase.Entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Long id;
    private int count;
    private Long productId;

    public static OrderItemDTO fromEntity(OrderItem refer){
        return new OrderItemDTO(refer.getId(), refer.getCount(),refer.getProduct().getId());
    }
}
