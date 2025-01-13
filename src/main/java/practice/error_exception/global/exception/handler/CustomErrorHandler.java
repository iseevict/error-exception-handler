package practice.error_exception.global.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.util.ErrorHandler;
import practice.error_exception.global.exception.object.ServiceException;

@Slf4j
public class CustomErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        if (t instanceof ServiceException) {
            log.error("Service error occurred: {}", t.getClass().getName());
            log.error("Error Message: {}", t.getMessage());
        } else {
            log.error("Unexpected error occurred: {}", t.getClass().getName());
            log.error("Error Message: {}", t.getMessage(), t.getCause());
        }
    }
}
