package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderXMLRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("file:files/xml")
                .log("${body}")
        .to("activemq:my-xml-format-queue");
    }
}
