package com.example.messagingapp.service;

import com.example.messagingapp.config.KafkaConfig;
import com.example.messagingapp.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        logger.info("Producing order to Kafka: {}", order.getOrderId());
        kafkaTemplate.send(KafkaConfig.ORDER_TOPIC, order.getOrderId(), order)
                     .whenComplete((result, ex) -> {
                         if (ex != null) {
                             logger.error("Failed to publish order {}", order.getOrderId(), ex);
                         } else {
                             logger.info("Order published successfully: {}", order.getOrderId());
                         }
                     });
    }
}
