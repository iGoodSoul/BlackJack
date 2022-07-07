package by.vasiliev.blackjack.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiException {

    private final HttpStatus status;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiException(String message, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}