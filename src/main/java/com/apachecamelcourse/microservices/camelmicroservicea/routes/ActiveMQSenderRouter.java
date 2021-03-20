package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My message for ActiveMQ")
                .log("${body}")
                .to("activemq:my-activemq-queue");
                //.to("log:first-timer");
    }
}
