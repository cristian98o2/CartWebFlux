package co.com.pragma.router.config;

import co.com.pragma.router.CartWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfig {

    private final CartWebSocketHandler myWebSocketHandler;

    public WebSocketConfig(CartWebSocketHandler cartWebSocketHandler) {
        this.myWebSocketHandler = cartWebSocketHandler;
    }

    @Bean
    public HandlerMapping webSocketMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/ws/cart", myWebSocketHandler);  // Define la ruta del WebSocket

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(1);
        mapping.setUrlMap(map);
        return mapping;
    }
}

