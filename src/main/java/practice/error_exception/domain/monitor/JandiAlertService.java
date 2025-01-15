package practice.error_exception.domain.monitor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class JandiAlertService {
    private final String WEBHOOK_URL = "https://wh.jandi.com/connect-api/webhook/33156233/7f7d89e6a413577709d6c5f595fcd5ac";

    public void sendAlert(String message) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> payload = new HashMap<>();
        payload.put("body", message);
        payload.put("connectColor", "#FF0000");
        payload.put("connectInfo", new Object[]{
                Map.of("title", "Alert Message", "description", message)
        });

        restTemplate.postForObject(WEBHOOK_URL, payload, String.class);
    }
}
