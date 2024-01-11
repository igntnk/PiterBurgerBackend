package app.dto.kafkadto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaProductDTO {
    private Long id;
    private String name;
    private String description;
    private String photo;
    private int price;
    private boolean enabled;
    private Long threadNumber;
    private Long threadAmount;
}
