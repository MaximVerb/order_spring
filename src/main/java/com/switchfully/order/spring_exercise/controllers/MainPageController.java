package com.switchfully.order.spring_exercise.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class MainPageController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getHelloWorld(CsrfToken csrfToken , HttpServletResponse response) {
        response.addHeader("X-CSRF-HEADER", csrfToken.getToken());
        return "Hello World";
    }
}
