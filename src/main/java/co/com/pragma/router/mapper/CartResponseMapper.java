package co.com.pragma.router.mapper;

import co.com.pragma.domain.model.Cart;
import co.com.pragma.router.dto.CartResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartResponseMapper {

    CartResponseMapper MAPPER = Mappers.getMapper(CartResponseMapper.class);

    CartResponseDto toDto(Cart cart);

}
