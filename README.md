# Messaging App

Aplicação de exemplo Java Spring Boot usando Kafka.

## Visão geral

Este projeto implementa um caso de uso simples de pedidos (`Order`) com Kafka.
- `POST /orders` cria um pedido e envia para o tópico Kafka.
- O consumidor Kafka processa o pedido.

## Requisitos

- Java 23+
- Maven 3.9+
- Apache Kafka em execução localmente em `localhost:9092`

## Como executar

1. Inicie o Kafka localmente.
2. Execute o aplicativo:

```bash
mvn spring-boot:run
```

3. Envie um pedido:

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"orderId":"123","product":"Notebook","quantity":2}'
```

## Configuração

A configuração do Kafka está em `src/main/resources/application.yml`.

## Estrutura

- `OrderController` recebe requisições HTTP.
- `OrderProducer` publica mensagens Kafka.
- `OrderConsumer` consome mensagens Kafka do tópico `orders`.
