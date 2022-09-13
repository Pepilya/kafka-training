package com.advanced.message.training.kafka.infrastructure;

import com.advanced.message.training.kafka.application.Order;
import com.advanced.message.training.kafka.application.OrderService;
import com.advanced.message.training.kafka.config.Sink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {
    private final OrderService orderService;

    @StreamListener(Sink.ORDERS)
    public void processEvent(Message<Order> message) {
        //acknowledgment before process order establishing "at most one" semantic
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
        Order order = message.getPayload();
        log.info("Get order with payload == {} \n headers == {} \n", order, message.getHeaders());
        orderService.process(order);
    }
}
