package practice.error_exception.domain.monitor;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaHealthProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendHealthStatus(String topic, String status) {
        kafkaTemplate.send("health-status", status);
        System.out.println("Message sent to topic: " + topic + " - " + status);
    }
}
