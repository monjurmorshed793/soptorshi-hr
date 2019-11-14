package org.soptorshi.web.rest;

import org.soptorshi.service.SoptorshiHrKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/soptorshi-hr-kafka")
public class SoptorshiHrKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SoptorshiHrKafkaResource.class);

    private SoptorshiHrKafkaProducer kafkaProducer;

    public SoptorshiHrKafkaResource(SoptorshiHrKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
