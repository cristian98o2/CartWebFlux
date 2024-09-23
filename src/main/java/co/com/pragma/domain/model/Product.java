package co.com.pragma.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonDeserialize
public class Product implements Cloneable {
    private Long id;
    private String idSku;
    private List<String> idCategories;
    private String idBrand;
    private BigDecimal price;
    private BigDecimal newPrice;
    private String inventoryType;
    private String inventoryUnit;
    private Integer inventoryUnitEquivalent;
    private BigDecimal ico;
    private BigDecimal iva;
    private List<CompensationPlan> compensationPlanList;
    private List<AppliedDiscount> appliedDiscounts;
    private String salesMotive;
    private Integer quantity;
    private String name;
    private String description;
    private String image;
    private String warehouse;
    private BigDecimal discount;
    private String comboSku;
    private String nameDiscount;
    private BigDecimal percentValue;
    private BigDecimal selfCompensation;
    private BigDecimal discountMarketing;
    private BigDecimal cuponDiscount;
    private BigDecimal stock;
    private boolean isAvailalble = Boolean.TRUE;

    /*
     * This implementation is a simile with Prototype pattern
     * Review this post: https://refactoring.guru/es/design-patterns/prototype
     */
    @Override
    public Product clone() throws CloneNotSupportedException {
        Product cloned = (Product) super.clone();

        if (this.compensationPlanList != null) {
            cloned.compensationPlanList = new ArrayList<>();
            for (CompensationPlan plan : this.compensationPlanList) {
                cloned.compensationPlanList.add(plan.clone());
            }
        }

        return cloned;
    }

    public Product(Product product) {
        this.id = product.getId();
        this.idSku = product.getIdSku();
        this.idCategories = product.getIdCategories();
        this.idBrand = product.getIdBrand();
        this.price = product.getPrice();
        this.newPrice = product.getNewPrice();
        this.inventoryType = product.getInventoryType();
        this.inventoryUnit = product.getInventoryUnit();
        this.inventoryUnitEquivalent = product.getInventoryUnitEquivalent();
        this.ico = product.getIco();
        this.iva = product.getIva();
        this.compensationPlanList = product.getCompensationPlanList();
        this.appliedDiscounts = product.getAppliedDiscounts();
        this.salesMotive = product.getSalesMotive();
        this.quantity = product.getQuantity();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.warehouse = product.getWarehouse();
    }
}
