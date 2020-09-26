package com.avinash.learning.springwebservices.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Getter
@Setter
public class CustomException {

    private String message;
    private Date timestamp;
    private String details;

    public CustomException(String message, Date timestamp, String details) {
        super();
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }
}
