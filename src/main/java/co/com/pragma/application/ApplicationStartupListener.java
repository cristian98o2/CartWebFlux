package co.com.pragma.application;

import co.com.pragma.router.CartWebSocketHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String[] handlerMappings = applicationContext.getBeanNamesForType(CartWebSocketHandler.class);

        for (String handlerMapping : handlerMappings) {
            //System.out.println("Registered HandlerMapping: " + handlerMapping);
        }
    }
}
