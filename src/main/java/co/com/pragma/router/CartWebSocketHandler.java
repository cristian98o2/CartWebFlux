package co.com.pragma.router;

import co.com.pragma.domain.model.Cart;
import co.com.pragma.domain.usecase.DeleteCartUseCase;
import co.com.pragma.domain.usecase.GetCartActiveUseCase;
import co.com.pragma.domain.usecase.SaveOrUpdateCartUseCase;
import co.com.pragma.router.mapper.CartResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static co.com.pragma.utils.authorization.AuthorizationToken.getIdUser;

@Component
@RequiredArgsConstructor
@Slf4j
public class CartWebSocketHandler implements WebSocketHandler {

    private final GetCartActiveUseCase getCartActiveUseCase;
    private final DeleteCartUseCase deleteCartUseCase;
    private final SaveOrUpdateCartUseCase saveOrUpdateCartUseCase;

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<WebSocketSession>> userSessions = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> handle(WebSocketSession sender) {
        String userId = extractUserIdFromSession(sender);
        userSessions.computeIfAbsent(userId, key -> new CopyOnWriteArrayList<>()).add(sender);

        return sender.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .flatMap(body -> Flux.fromIterable(userSessions.get(userId))
                            .flatMap(session -> {
                                try {
                                    return routMessage(body, userId)
                                            .flatMap(message -> session.send(Mono.just(session.textMessage(message))));
                                } catch (JsonProcessingException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .then())
                .onErrorResume(error -> sender.send(Mono.just(sender.textMessage("Internal server error"))))
                .doOnTerminate(() -> removeUserSession(userId, sender))
                .then();
    }

    private Mono<String> routMessage(String body, String userId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Mono<JsonNode> jsonNode = Mono.just(objectMapper.readTree(body));
        return jsonNode.flatMap(json -> {
            String type = json.get("type").asText();
            return switch (type) {
                case "getCartActive" -> getCartActive(userId);
                case "paidCart" -> deleteCart(userId);
                case "saveOrUpdateCart" -> saveOrUpdateCart(json.get("payload"));
                default -> Mono.just("Type desconocido: " + type);
            };
        });
    }

    private Mono<String> getCartActive(String userId){
        return getCartActiveUseCase.execute(userId).defaultIfEmpty(new Cart())
                .flatMap(cart -> {
                    if (cart.getIdCart() != null) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            return Mono.just(objectMapper.writeValueAsString(CartResponseMapper.MAPPER.toDto(cart)));
                        } catch (JsonProcessingException e) {
                            return Mono.error(new RuntimeException(e));
                        }
                    } else {
                        return Mono.just("Cart not found");
                    }
                })
                .onErrorResume(error -> Mono.just("Internal server error"));
    }

    private Mono<String> deleteCart(String userId) {
        return deleteCartUseCase.execute(userId)
                .then(Mono.defer(() -> Mono.just("Pago completado")))
                .onErrorResume(error -> Mono.just("Internal server error"));
    }

    private Mono<String> saveOrUpdateCart(JsonNode payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return saveOrUpdateCartUseCase.execute(objectMapper.readValue(objectMapper.writeValueAsString(payload), Cart.class))
                    .flatMap(cart -> {
                        try {
                            return Mono.just(objectMapper.writeValueAsString(CartResponseMapper.MAPPER.toDto(cart)));
                        } catch (JsonProcessingException e) {
                            return Mono.error(new RuntimeException(e));
                        }
                    })
                    .onErrorResume(error -> Mono.just("Internal server error"));
        } catch (JsonProcessingException e) {
            return Mono.just("Internal server error");
        }
    }

    private String extractUserIdFromSession(WebSocketSession session) {
        return getIdUser(session.getHandshakeInfo().getHeaders().getFirst("Authorization"));
    }

    private void removeUserSession(String userId, WebSocketSession session) {
        List<WebSocketSession> sessions = userSessions.get(userId);
        if (sessions != null) {
            sessions.remove(session);
            if (sessions.isEmpty()) {
                userSessions.remove(userId);
            }
        }
    }
}

