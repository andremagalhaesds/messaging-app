package com.example.messagingapp.service;

import com.example.messagingapp.config.KafkaConfig;
import com.example.messagingapp.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = KafkaConfig.ORDER_TOPIC, groupId = "order-consumer-group")
    public void onOrderReceived(Order order) {
        logger.info("Pedido recebido do Kafka: orderId={}, product={}, quantity={}, createdAt={}",
                order.getOrderId(), order.getProduct(), order.getQuantity(), order.getCreatedAt());
        // Aqui você pode implementar regras de negócio reais como persistência, validação e processamento.
    }
}
