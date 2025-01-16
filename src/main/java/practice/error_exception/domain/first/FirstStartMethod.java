package practice.error_exception.domain.first;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class FirstStartMethod {

    @PostConstruct
    public void init() throws InterruptedException {
        System.out.println("First Print");
        Thread.sleep(10000);
        System.out.println("Wake up");
    }
}
