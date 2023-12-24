package app.messages;

import app.dto.OrderDTO;
import app.dto.small.SmallOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderMessage {
    String email;
    SmallOrderDTO order;
}
