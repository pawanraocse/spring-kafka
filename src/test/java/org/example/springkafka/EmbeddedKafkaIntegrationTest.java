package org.example.springkafka;

import org.example.springkafka.consumer.service.KafkaConsumer;
import org.example.springkafka.producer.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducerService producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingWithSimpleProducer_thenMessageReceived()
        throws Exception {
        String data = "Sending with our own simple KafkaProducer";

        producer.sendMessage(topic, data);

        //boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
        //assertTrue(messageConsumed);
        //assertThat(consumer.getPayload(), containsString(data));
    }
}
