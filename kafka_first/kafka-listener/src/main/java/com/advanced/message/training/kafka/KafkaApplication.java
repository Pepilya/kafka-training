package com.advanced.message.training.kafka;

import com.advanced.message.training.kafka.config.Sink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Sink.class)
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
