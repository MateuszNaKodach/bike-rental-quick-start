package io.axoniq.demo.bikerental.payment.dummy;


import io.axoniq.demo.bikerental.coreapi.payment.dummy.DummyQuery;
import io.axoniq.demo.bikerental.coreapi.payment.dummy.DummyQueryResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class DummyQueryHandler {

    @QueryHandler(queryName = "dummy")
    DummyQueryResponse handle(DummyQuery query) throws InterruptedException {
        Thread.sleep(5000);
        return new DummyQueryResponse("hi!");
    }
}
