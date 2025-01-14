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
    public void LogTest() {
        Thread.currentThread().setName("EmfoGMS-LogTest");
        log.error("This is the test to check if Logs are logged in the gmsLog file");
    }

    @Scheduled(fixedDelay = 10000)
    public void CustomExceptionsTest() {
        Thread.currentThread().setName("EmfoGMS-CustomExceptions");
        throw new testHandler("TEST001", "Exception for Custom Exception Test");
    }

    @Scheduled(fixedDelay = 10000)
    public void AllExceptionsTest() {
        Thread.currentThread().setName("EmfoGMS-AllExceptions");
        log.error("Exception for All Exception Test.");
        throw new IllegalArgumentException();
    }
}
