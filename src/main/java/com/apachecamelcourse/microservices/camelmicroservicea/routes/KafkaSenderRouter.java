package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("file:files/json/kafka")
                .log("${body}")
                .to("kafka:my-json-format-topic");
    }
}
