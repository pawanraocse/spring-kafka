package org.example.springkafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class SpringKafkaApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testProducer() {
        String message = "Hello, Kafka!";
        kafkaTemplate.send("my-topic", message);
        // Assert that message is received by consumer (implement using tools like Mockito)
    }

}
