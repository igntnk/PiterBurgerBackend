package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String photo;
    private int price;
    private boolean enabled;
}
