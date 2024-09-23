package co.com.pragma.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @GetMapping("/test")
    public String test() {
        return "WebSocket test is working!";
    }
}
