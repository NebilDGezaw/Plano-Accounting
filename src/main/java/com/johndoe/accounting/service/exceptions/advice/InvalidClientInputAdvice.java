package com.johndoe.accounting.service.exceptions.advice;

import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nebil on 12/4/18.
 */
@ControllerAdvice
public class InvalidClientInputAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidClientInputException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String InvalidClientInputHandler(InvalidClientInputException invalid) {
        return invalid.getMessage();
    }

}
