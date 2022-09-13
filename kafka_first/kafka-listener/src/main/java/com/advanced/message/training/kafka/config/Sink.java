package com.advanced.message.training.kafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    String ORDERS = "orders";

    @Input(ORDERS)
    SubscribableChannel getOrder();

}
