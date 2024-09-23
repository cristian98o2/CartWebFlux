package co.com.pragma.domain.usecase;

import co.com.pragma.domain.model.Cart;
import co.com.pragma.domain.model.gateway.CartRepositoryGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveOrUpdateCartUseCase {

    private final CartRepositoryGateway cartRepositoryGateway;

    public Mono<Cart> execute( Cart cart) {
        return cartRepositoryGateway.saveCarts(Mono.just(cart)).onErrorResume(error -> Mono.empty());
    }
}
