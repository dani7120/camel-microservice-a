package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApiSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port("8000");
         from("timer:rest-api-call?period=10000")
                 .log("${body}")
                 .to("rest:get:/historic/title/test from camel")
                 .log("${body}");
    }
}
