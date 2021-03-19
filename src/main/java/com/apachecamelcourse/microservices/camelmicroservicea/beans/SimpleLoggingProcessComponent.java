package com.apachecamelcourse.microservices.camelmicroservicea.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessComponent {

    Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessComponent.class);

    public void process(String message){
        logger.info("SimpleLoggingProcessComponent: {}", message);
    }
}
