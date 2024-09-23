package co.com.pragma.domain.model.gateway;

import co.com.pragma.domain.model.Cart;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CartRepositoryGateway {
    Mono<Cart> getCart(String idUser);

    Mono<Cart> saveCarts(Mono<Cart> cart);

    Mono<Void> completeCart(String idUser);

}
