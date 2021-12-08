package com.switchfully.order.spring_exercise.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityCouldNotBeFoundExc.class) //FIXME you could put the same hhtp with an array
    protected void entityDoesNotExistInDb(EntityCouldNotBeFoundExc exception,
                                          HttpServletResponse response) throws IOException {
        response.sendError(NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected void entityDoesNotExistInDb(IllegalArgumentException exception,
                                          HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    protected void authenticationFailed(AuthenticationException exception,
                                        HttpServletResponse response) throws IOException {
        System.out.println(exception.getMessage());
        response.sendError(FORBIDDEN.value(), exception.getMessage());
    }
}
