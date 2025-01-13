package practice.error_exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErrorExceptionApplication {

	public static void main(String[] args) {

		int none = 0;
		none = 1;
		SpringApplication.run(ErrorExceptionApplication.class, args);
	}

}
