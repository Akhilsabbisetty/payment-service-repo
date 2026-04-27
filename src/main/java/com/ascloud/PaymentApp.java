package com.ascloud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class, args);
    }
}

@Component
class Consumer {

    @KafkaListener(topics = "orders")
    public void consume(String msg) {
        System.out.println("Processing payment: " + msg);
    }
}