package Application.DTO.SmallDTOs;

import Application.DTO.OrderItemDTO;
import lombok.Data;

import java.util.List;

@Data
public class SmallOrderDTO {
    private String comment;
    private List<SmallOrderItemDTO> items;
}