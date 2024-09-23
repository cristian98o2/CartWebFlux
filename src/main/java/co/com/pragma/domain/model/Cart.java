package co.com.pragma.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonDeserialize
public class Cart implements Cloneable{
    private Long id;
    private String idCart;
    private User user;
    private Shipping shipping;
    private String channel;
    private String warehouse;
    private List<Product> products;
    @Builder.Default
    private List<Product> giftProducts = new ArrayList<>();
    private String voucher;
    private String paymentMethod;
    private BigDecimal carrierPrice;
    private LocalDateTime createdAt;
    private CartStatus status;
    private BigDecimal discount;
    private BigDecimal discountMarketing;
    private BigDecimal selfCompensation;
    private BigDecimal icoTotal;
    private BigDecimal ivaTotal;
    private BigDecimal subtotal;
    private BigDecimal total;
    private String messageId;
    private String idCarrier;
    private String comment;
    private List<AppliedDiscount> appliedDiscounts;
    private List<Combo> combos;
    private String carrierIdSku;
    private Long idDeliveryMethod;

    @Override
    public Cart clone() throws CloneNotSupportedException
    {
        return (Cart) super.clone();
    }
}
