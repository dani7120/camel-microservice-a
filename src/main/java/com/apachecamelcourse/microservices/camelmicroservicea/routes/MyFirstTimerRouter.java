package com.apachecamelcourse.microservices.camelmicroservicea.routes;

import com.apachecamelcourse.microservices.camelmicroservicea.beans.GetCurrentTimeBean;
import com.apachecamelcourse.microservices.camelmicroservicea.beans.SimpleLoggingProcessComponent;
import com.apachecamelcourse.microservices.camelmicroservicea.processors.SimpleLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// disable this router
//@Component
public class MyFirstTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;
    private final SimpleLoggingProcessComponent simpleLoggingProcessComponent;

    @Autowired
    public MyFirstTimerRouter(GetCurrentTimeBean getCurrentTimeBean, SimpleLoggingProcessComponent simpleLoggingProcessComponent) {
        this.getCurrentTimeBean = getCurrentTimeBean;
        this.simpleLoggingProcessComponent = simpleLoggingProcessComponent;
    }

    @Override
    public void configure() throws Exception {
        from("timer:first-timer")
                .log("${body}")
                .transform().constant("My Constant Message")
                .log("${body}")
                // specify a method name if you have more that one in your bean
                .bean(getCurrentTimeBean, "getCurrentTime")
                .log("${body}")
                .bean(simpleLoggingProcessComponent)
                .log("${body}")
                .process(new SimpleLoggingProcessor())
                .to("log:first-timer");
    }

}
