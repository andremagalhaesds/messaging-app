# Messaging App

Example Java Spring Boot application using Kafka.

## Overview

This project implements a simple order (`Order`) use case with Kafka.
- `POST /orders` creates an order and sends it to a Kafka topic.
- The Kafka consumer processes the order.

## Requirements

- Java 23+
- Maven 3.9+
- Apache Kafka running locally at `localhost:9092`

## How to run

1. Start Kafka locally.
2. Run the application:

```bash
mvn spring-boot:run
```

3. Send an order:

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"orderId":"123","product":"Notebook","quantity":2}'
```

## Configuration

Kafka configuration is in `src/main/resources/application.yml`.

## Structure

- `OrderController` receives HTTP requests.
- `OrderProducer` publishes Kafka messages.
- `OrderConsumer` consumes Kafka messages from the `orders` topic.
