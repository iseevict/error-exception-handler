package practice.error_exception.domain.aop;

import org.springframework.stereotype.Service;
import practice.error_exception.global.exception.handler.testHandler;

@Service
public class AopTestService {

    @AopTestAnnotation
    public String processData(String input) {
        if (input == null) {
            throw new testHandler("AOPtest", "AopTestMessage");
        }
        return "Processed: " + input;
    }
}
