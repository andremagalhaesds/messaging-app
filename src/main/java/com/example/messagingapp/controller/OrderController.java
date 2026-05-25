package com.example.messagingapp.controller;

import com.example.messagingapp.model.Order;
import com.example.messagingapp.service.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order request) {
        Order order = new Order(
                request.getOrderId(),
                request.getProduct(),
                request.getQuantity(),
                Instant.now()
        );

        orderProducer.sendOrder(order);
        return ResponseEntity.accepted().body(order);
    }
}
