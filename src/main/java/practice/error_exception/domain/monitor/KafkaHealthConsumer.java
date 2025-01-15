package practice.error_exception.domain.monitor;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaHealthConsumer {
    private final JandiAlertService jandiAlertService;

    @KafkaListener(topics = "health-status", groupId = "monitoring")
    public void consumeStatus(String message) {
        if (message.equals("Test")) {
            jandiAlertService.sendAlert(message);
        }
        System.out.println("Received health status: " + message);
        if (message.contains("NOT OK")) {
            sendAlert(message);
        }
    }

    private void sendAlert(String alertMessage) {
        System.out.println("ALERT: " + alertMessage);
    }
}
