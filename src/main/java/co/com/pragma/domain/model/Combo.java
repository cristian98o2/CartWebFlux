package co.com.pragma.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonDeserialize
public class Combo {

    private String id;
    private Integer quantity;
    private List<Product> products;
    private BigDecimal discount;
    private String nombre;
    private String descripcion;
    private BigDecimal price;
    private BigDecimal precioRegular;
    private List<String> idCategories;
    private String images;
    private boolean ocultar;
    private String warehouse;
    private BigDecimal stock;
    private boolean isAvailable = Boolean.TRUE;
    private List<AppliedDiscount> appliedDiscounts;
}
