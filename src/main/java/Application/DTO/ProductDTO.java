package Application.DTO;

import Application.DataBase.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private boolean enabled;

    public static ProductDTO fromEntity(Product refer){
        return new ProductDTO(refer.getId(), refer.getName(), refer.getDescription(), refer.getPrice(), refer.isEnabled());
    }
}
