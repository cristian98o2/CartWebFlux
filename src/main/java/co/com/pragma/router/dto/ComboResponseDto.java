package co.com.pragma.router.dto;

import co.com.pragma.domain.model.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class ComboResponseDto {
    private String id;
    private long quantity;
    private List<Product> products;
    private BigDecimal discount;
    private String nombre;
    private String descripcion;
    private BigDecimal price;
    private BigDecimal precioRegular;
    private List<String> idCategories;
    private String images;
    private boolean ocultar;
    private BigDecimal stock;
}
