package com.advanced.message.training.producer.infrastructure;

import com.advanced.message.training.producer.application.service.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final CustomProcessor processor;

    public void publishEvent(Order order) {
        processor.output().send(
                MessageBuilder
                        .withPayload(order)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build());
    }

}
