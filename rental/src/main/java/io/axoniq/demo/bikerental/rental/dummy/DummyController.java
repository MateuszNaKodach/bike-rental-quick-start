package io.axoniq.demo.bikerental.rental.dummy;

import io.axoniq.demo.bikerental.payment.DummyQuery;
import io.axoniq.demo.bikerental.payment.DummyQueryResponse;
import org.axonframework.queryhandling.QueryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class DummyController {

    private static final Logger logger = LoggerFactory.getLogger(DummyController.class);

    private final QueryGateway queryGateway;

    public DummyController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/dummy")
    ResponseEntity<?> dummyQuery() throws InterruptedException {
        logger.info("INVESTIGATION Before sleep...");
        Thread.sleep(3000);
        logger.info("INVESTIGATION After sleep...");
        var dummyQuery = new DummyQuery();
        try {
            var resultOpt = queryGateway.query(
                    dummyQuery,
                    DummyQueryResponse.class
            );
            var result = resultOpt.get(60L, TimeUnit.SECONDS);
            logger.info("INVESTIGATION Query executed...");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("INVESTIGATION error", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
