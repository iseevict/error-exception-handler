package practice.error_exception.domain.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import practice.error_exception.global.exception.handler.testHandler;
import practice.error_exception.global.exception.object.ServiceException;

@Service
@Slf4j
public class testService {

    @Scheduled(fixedDelay = 10000)
    public void logTest() {
        log.error("test");

        throw new testHandler("test", "test");
    }
}
