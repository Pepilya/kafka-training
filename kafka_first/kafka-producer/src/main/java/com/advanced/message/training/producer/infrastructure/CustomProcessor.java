package com.advanced.message.training.producer.infrastructure;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomProcessor {

    String ORDERS = "orders";

    @Output(ORDERS)
    MessageChannel output();

}
