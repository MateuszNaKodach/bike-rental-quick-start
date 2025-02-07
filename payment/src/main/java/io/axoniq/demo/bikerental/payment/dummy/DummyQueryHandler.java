package io.axoniq.demo.bikerental.payment.dummy;


import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class DummyQueryHandler {

    @QueryHandler
    DummyQueryResponse handle(DummyQuery query) throws InterruptedException {
        Thread.sleep(5000);
        return new DummyQueryResponse("hi!");
    }
}
