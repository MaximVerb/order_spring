package com.switchfully.order.spring_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
//@EnableAspectJAutoProxy
@Lazy
public class SpringExerciseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringExerciseApplication.class, args);
    }
}
