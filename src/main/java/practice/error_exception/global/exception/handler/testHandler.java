package practice.error_exception.global.exception.handler;

import org.springframework.http.HttpStatus;
import practice.error_exception.global.exception.object.ServiceException;

public class testHandler extends ServiceException {

    public testHandler(String errorCode, String message) {
        super(HttpStatus.BAD_REQUEST, errorCode, message);
    }
}
