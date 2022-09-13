package com.advanced.message.training.producer;

import com.advanced.message.training.producer.infrastructure.CustomProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
@EnableBinding(CustomProcessor.class)
public class ProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class, args);
    }

}

