package com.company.orders.client.decoder;

public enum JsonNodeFıeldName {

    MESSAGE("message");
    private final String value;

    JsonNodeFıeldName(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

}
