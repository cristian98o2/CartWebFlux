package co.com.pragma.router.dto;

import co.com.pragma.domain.model.CartStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Schema(description = "Modelo de entrada de datos para salvar un carrito por usuario")
@ToString
public class CartResponseDto {
    @Schema(description = "Id de carrito en caso de tenerlo.")
    private String idCart;
    @Schema(description = "Canal de venta de los productos.")
    private String channel;
    @Schema(description = "Bodega de donde salen los productos.")
    private String warehouse;
    @Schema(description = "Productos del carrito.")
    private List<ProductResponseDto> products;
    @Schema(description = "Productos del carrito regalados por promociones.")
    private List<ProductResponseDto> giftProducts;
    @Schema(description = "Combos del carrito")
    private List<ComboResponseDto> combos;
    @Schema(description = "Cupon que se va aplicar.")
    private String voucher;
    @Schema(description = "Metodo de pago.")
    private String paymentMethod;
    @Schema(description = "Valor de envio.")
    private BigDecimal carrierPrice;
    @Schema(description = "Estado del carrito.")
    private CartStatus status;
    @Schema(description = "Precio total del carrito.")
    private BigDecimal discount;
    @Schema(description = "Descuento Marketing del carrito.")
    private BigDecimal discountMarketing;
    @Schema(description = "Precio total del carrito.")
    private BigDecimal selfCompensation;
    @Schema(description = "Precio total del carrito.")
    private BigDecimal icoTotal;
    @Schema(description = "Precio total del carrito.")
    private BigDecimal ivaTotal;
    @Schema(description = "Subtotal del carrito.")
    private BigDecimal subtotal;
    @Schema(description = "Precio total del carrito.")
    private BigDecimal total;
    @Schema(description = "Comentario del carrito.")
    private String comment;
    @Schema(description = "Lista de skus no disponibles")
    private List<FieldModelErrorsDtos> fieldModelErrors;
    private List<AppliedDiscountResponseDto> appliedDiscounts;
}

