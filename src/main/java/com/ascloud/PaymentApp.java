package com.ascloud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class PaymentApp {

    @KafkaListener(topics = "orders")
    public void consume(String msg) {
        System.out.println("Payment processed: " + msg);
    }

    @GetMapping("/payment")
    public String status() {
        return "Payment Service Running";
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class, args);
    }
}