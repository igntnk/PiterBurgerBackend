package Application.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String comment;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private OffsetDateTime creationDate;
    private String status;
    private List<OrderItemDTO> items;

    public OrderDTO(String comment, String status, List<OrderItemDTO> items) {
        this.comment = comment;
        this.status = status;
        this.items = items;
    }
}
