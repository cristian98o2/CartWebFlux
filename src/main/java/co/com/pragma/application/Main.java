package co.com.pragma.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"co.com.pragma", "co.com.pragma.router", "co.com.pragma.router.config"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}