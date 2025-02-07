package io.axoniq.demo.bikerental.coreapi.payment.dummy;


public class DummyQueryResponse {

    private String value;

    public DummyQueryResponse() {
    }

    public DummyQueryResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}