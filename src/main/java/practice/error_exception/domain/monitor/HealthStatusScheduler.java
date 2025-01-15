package practice.error_exception.domain.monitor;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HealthStatusScheduler {
    private final KafkaHealthProducer kafkaHealthProducer;

    @Scheduled(fixedRate = 10000)
    public void reportHealthStatus() {
        String healthStatus = checkHealth() ? "OK" : "NOT OK";
        kafkaHealthProducer.sendHealthStatus("test", "Service XYZ: " + healthStatus);
    }

    private boolean checkHealth() {

        return true;
    }
}
