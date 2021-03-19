package com.apachecamelcourse.microservices.camelmicroservicea.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeBean {
    public String getCurrentTime(){
        return "From Bean Time now is: " + LocalDateTime.now();
    }
}