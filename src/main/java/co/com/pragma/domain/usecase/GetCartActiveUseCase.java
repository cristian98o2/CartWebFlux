package co.com.pragma.domain.usecase;

import co.com.pragma.domain.model.Cart;
import co.com.pragma.domain.model.gateway.CartRepositoryGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetCartActiveUseCase {

    private final CartRepositoryGateway cartRepositoryGateway;

    public Mono<Cart> execute(String idUser){
        return cartRepositoryGateway.getCart(idUser).onErrorResume(error -> Mono.empty());
    }
}
