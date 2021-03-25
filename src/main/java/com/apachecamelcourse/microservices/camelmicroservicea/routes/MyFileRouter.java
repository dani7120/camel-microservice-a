package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .routeId("My File Router ")
                .transform().body(String.class)
                .choice()
                    .when(simple("${file:ext} ends with 'xml'")) // if
                        .log("XML FILE")
                    .otherwise() // else
                        .log("NOT an XML FILE")
                .end()
                .log("${body}")
                .log("${messageHistory}")
                .to("file:files/output");
    }
}
