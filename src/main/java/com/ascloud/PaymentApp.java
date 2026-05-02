package com.ascloud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class PaymentApp {

    @KafkaListener(topics = "orders")
    public void consume(String msg) {
        System.out.println("Payment processed: " + msg);
    }

    @GetMapping("/payment")
    public Map<String, String> status() {
        return Map.of(
            "service", "payment-service",
            "status", "running"
        );
    }

    @PostMapping("/payment/pay")
    public Map<String, String> makePayment(@RequestBody Map<String, Object> request) {
        return Map.of(
            "paymentStatus", "success",
            "transactionId", "TXN-" + System.currentTimeMillis(),
            "message", "Demo payment completed successfully"
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class, args);
    }
}