package util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BMSException extends RuntimeException {

	public BMSException(String message, Throwable cause) {
		super(message, cause);
	}

	public BMSException(String message) {
		super(message);
	}

	public BMSException(Throwable cause) {
		super(cause);
	}
	

	
}
