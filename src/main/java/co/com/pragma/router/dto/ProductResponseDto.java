package co.com.pragma.router.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class ProductResponseDto {
    private String idSku;
    private List<String> idCategories;
    private String idBrand;
    private BigDecimal price;
    private BigDecimal newPrice;
    private String inventoryType;
    private String inventoryUnit;
    private Integer inventoryUnitEquivalent;
    private String salesMotive;
    private BigDecimal ico;
    private BigDecimal iva;
    private Integer quantity;
    private BigDecimal discount;
    private List<AppliedDiscountResponseDto> appliedDiscounts;
    private BigDecimal stock;
}
