package app.dto.small;

import lombok.Data;

import java.util.List;

@Data
public class SmallOrderDTO {
    private String comment;
    private List<SmallOrderItemDTO> items;
}