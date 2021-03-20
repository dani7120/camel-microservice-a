package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderJSONRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("file:files/json")
                .log("${body}")
        .to("activemq:my-json-format-queue");
    }
}
