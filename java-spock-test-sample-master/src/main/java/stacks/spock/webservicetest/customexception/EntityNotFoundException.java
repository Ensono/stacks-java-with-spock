package stacks.spock.webservicetest.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * In Spring MVC,We have three ways to use @ResponseStatus to convert an Exception to an HTTP response status:
 * <p>
 * using @ExceptionHandler
 * using @ControllerAdvice
 * marking the Exception class
 * <p>
 * the most straightforward solution is the third one: marking the Exception class with @ResponseStatus:
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}

