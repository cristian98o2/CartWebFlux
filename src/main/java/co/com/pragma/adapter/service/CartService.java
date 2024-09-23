package co.com.pragma.adapter.service;

import co.com.pragma.domain.model.Cart;
import co.com.pragma.domain.model.CustomException;
import co.com.pragma.domain.model.ResponseCode;
import co.com.pragma.domain.model.gateway.CartRepositoryGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CartService implements CartRepositoryGateway {

    private final ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    public CartService(ReactiveRedisTemplate<String, Object> reactiveRedisTemplate, org.reactivecommons.utils.ObjectMapper objectMapper) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @Override
    public Mono<Cart> getCart(String idUser) {
        ObjectMapper objectMapper = new ObjectMapper();

        return reactiveRedisTemplate.opsForValue().get(idUser).map(json -> {
            try {
                String jsonString = json.toString();
                return objectMapper.readValue(jsonString, Cart.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Mono<Cart> saveCarts(Mono<Cart> cart){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return cart.flatMap(saveCart -> {
            try {
                return reactiveRedisTemplate.opsForValue().set(saveCart.getUser().getIdUser(), objectMapper.writeValueAsString(saveCart))
                        .flatMap(bool -> bool == Boolean.TRUE? Mono.just(saveCart): Mono.error(new CustomException(ResponseCode.LCC000)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Mono<Void> completeCart(String idUser) {
        return reactiveRedisTemplate.opsForValue().delete(idUser).then();
    }
}
