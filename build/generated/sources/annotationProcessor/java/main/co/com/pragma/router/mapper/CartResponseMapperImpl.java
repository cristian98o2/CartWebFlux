package co.com.pragma.router.mapper;

import co.com.pragma.domain.model.Action;
import co.com.pragma.domain.model.AppliedDiscount;
import co.com.pragma.domain.model.Cart;
import co.com.pragma.domain.model.Combo;
import co.com.pragma.domain.model.Product;
import co.com.pragma.router.dto.ActionResponseDto;
import co.com.pragma.router.dto.AppliedDiscountResponseDto;
import co.com.pragma.router.dto.CartResponseDto;
import co.com.pragma.router.dto.ComboResponseDto;
import co.com.pragma.router.dto.ProductResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-23T17:02:15-0500",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class CartResponseMapperImpl implements CartResponseMapper {

    @Override
    public CartResponseDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartResponseDto.CartResponseDtoBuilder cartResponseDto = CartResponseDto.builder();

        cartResponseDto.idCart( cart.getIdCart() );
        cartResponseDto.channel( cart.getChannel() );
        cartResponseDto.warehouse( cart.getWarehouse() );
        cartResponseDto.products( productListToProductResponseDtoList( cart.getProducts() ) );
        cartResponseDto.giftProducts( productListToProductResponseDtoList( cart.getGiftProducts() ) );
        cartResponseDto.combos( comboListToComboResponseDtoList( cart.getCombos() ) );
        cartResponseDto.voucher( cart.getVoucher() );
        cartResponseDto.paymentMethod( cart.getPaymentMethod() );
        cartResponseDto.carrierPrice( cart.getCarrierPrice() );
        cartResponseDto.status( cart.getStatus() );
        cartResponseDto.discount( cart.getDiscount() );
        cartResponseDto.discountMarketing( cart.getDiscountMarketing() );
        cartResponseDto.selfCompensation( cart.getSelfCompensation() );
        cartResponseDto.icoTotal( cart.getIcoTotal() );
        cartResponseDto.ivaTotal( cart.getIvaTotal() );
        cartResponseDto.subtotal( cart.getSubtotal() );
        cartResponseDto.total( cart.getTotal() );
        cartResponseDto.comment( cart.getComment() );
        cartResponseDto.appliedDiscounts( appliedDiscountListToAppliedDiscountResponseDtoList( cart.getAppliedDiscounts() ) );

        return cartResponseDto.build();
    }

    protected ActionResponseDto actionToActionResponseDto(Action action) {
        if ( action == null ) {
            return null;
        }

        ActionResponseDto.ActionResponseDtoBuilder actionResponseDto = ActionResponseDto.builder();

        actionResponseDto.application( action.getApplication() );
        actionResponseDto.discountType( action.getDiscountType() );
        actionResponseDto.operation( action.getOperation() );
        actionResponseDto.value( action.getValue() );

        return actionResponseDto.build();
    }

    protected List<ActionResponseDto> actionListToActionResponseDtoList(List<Action> list) {
        if ( list == null ) {
            return null;
        }

        List<ActionResponseDto> list1 = new ArrayList<ActionResponseDto>( list.size() );
        for ( Action action : list ) {
            list1.add( actionToActionResponseDto( action ) );
        }

        return list1;
    }

    protected AppliedDiscountResponseDto appliedDiscountToAppliedDiscountResponseDto(AppliedDiscount appliedDiscount) {
        if ( appliedDiscount == null ) {
            return null;
        }

        AppliedDiscountResponseDto.AppliedDiscountResponseDtoBuilder appliedDiscountResponseDto = AppliedDiscountResponseDto.builder();

        appliedDiscountResponseDto.name( appliedDiscount.getName() );
        appliedDiscountResponseDto.actions( actionListToActionResponseDtoList( appliedDiscount.getActions() ) );

        return appliedDiscountResponseDto.build();
    }

    protected List<AppliedDiscountResponseDto> appliedDiscountListToAppliedDiscountResponseDtoList(List<AppliedDiscount> list) {
        if ( list == null ) {
            return null;
        }

        List<AppliedDiscountResponseDto> list1 = new ArrayList<AppliedDiscountResponseDto>( list.size() );
        for ( AppliedDiscount appliedDiscount : list ) {
            list1.add( appliedDiscountToAppliedDiscountResponseDto( appliedDiscount ) );
        }

        return list1;
    }

    protected ProductResponseDto productToProductResponseDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDto.ProductResponseDtoBuilder productResponseDto = ProductResponseDto.builder();

        productResponseDto.idSku( product.getIdSku() );
        List<String> list = product.getIdCategories();
        if ( list != null ) {
            productResponseDto.idCategories( new ArrayList<String>( list ) );
        }
        productResponseDto.idBrand( product.getIdBrand() );
        productResponseDto.price( product.getPrice() );
        productResponseDto.newPrice( product.getNewPrice() );
        productResponseDto.inventoryType( product.getInventoryType() );
        productResponseDto.inventoryUnit( product.getInventoryUnit() );
        productResponseDto.inventoryUnitEquivalent( product.getInventoryUnitEquivalent() );
        productResponseDto.salesMotive( product.getSalesMotive() );
        productResponseDto.ico( product.getIco() );
        productResponseDto.iva( product.getIva() );
        productResponseDto.quantity( product.getQuantity() );
        productResponseDto.discount( product.getDiscount() );
        productResponseDto.appliedDiscounts( appliedDiscountListToAppliedDiscountResponseDtoList( product.getAppliedDiscounts() ) );
        productResponseDto.stock( product.getStock() );

        return productResponseDto.build();
    }

    protected List<ProductResponseDto> productListToProductResponseDtoList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductResponseDto> list1 = new ArrayList<ProductResponseDto>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductResponseDto( product ) );
        }

        return list1;
    }

    protected ComboResponseDto comboToComboResponseDto(Combo combo) {
        if ( combo == null ) {
            return null;
        }

        ComboResponseDto.ComboResponseDtoBuilder comboResponseDto = ComboResponseDto.builder();

        comboResponseDto.id( combo.getId() );
        if ( combo.getQuantity() != null ) {
            comboResponseDto.quantity( combo.getQuantity() );
        }
        List<Product> list = combo.getProducts();
        if ( list != null ) {
            comboResponseDto.products( new ArrayList<Product>( list ) );
        }
        comboResponseDto.discount( combo.getDiscount() );
        comboResponseDto.nombre( combo.getNombre() );
        comboResponseDto.descripcion( combo.getDescripcion() );
        comboResponseDto.price( combo.getPrice() );
        comboResponseDto.precioRegular( combo.getPrecioRegular() );
        List<String> list1 = combo.getIdCategories();
        if ( list1 != null ) {
            comboResponseDto.idCategories( new ArrayList<String>( list1 ) );
        }
        comboResponseDto.images( combo.getImages() );
        comboResponseDto.ocultar( combo.isOcultar() );
        comboResponseDto.stock( combo.getStock() );

        return comboResponseDto.build();
    }

    protected List<ComboResponseDto> comboListToComboResponseDtoList(List<Combo> list) {
        if ( list == null ) {
            return null;
        }

        List<ComboResponseDto> list1 = new ArrayList<ComboResponseDto>( list.size() );
        for ( Combo combo : list ) {
            list1.add( comboToComboResponseDto( combo ) );
        }

        return list1;
    }
}
