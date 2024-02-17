package org.example.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.springkafka.consumer.service.KafkaConsumer;
import org.example.springkafka.producer.service.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class KafkaUnitTest {
    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    @Captor
    private ArgumentCaptor<String> payloadCaptor;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testReceive() {
        KafkaConsumer kafkaConsumer = new KafkaConsumer();
        ConsumerRecord<String, String> consumerRecord = new ConsumerRecord<>("TEST", 0, 0, "key", "value");

        // When
        kafkaConsumer.processMessage(consumerRecord);

        // Then
        String expected = consumerRecord.toString();
        String actual = kafkaConsumer.getPayload();
        assertEquals(expected, actual);
    }
}
