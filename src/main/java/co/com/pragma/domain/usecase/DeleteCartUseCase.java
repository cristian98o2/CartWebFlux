package co.com.pragma.domain.usecase;

import co.com.pragma.domain.model.gateway.CartRepositoryGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCartUseCase {

    private final CartRepositoryGateway cartRepositoryGateway;

    public Mono<Void> execute(String userId) {
        return cartRepositoryGateway.completeCart(userId).onErrorResume(error -> Mono.empty());
    }
}
