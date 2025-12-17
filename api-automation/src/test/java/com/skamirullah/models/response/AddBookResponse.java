package com.skamirullah.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddBookResponse {

    @JsonProperty("Msg")
    private String msg;

    @JsonProperty("ID")
    private String id;

    public String getMsg() {
        return msg;
    }

    public String getID() {
        return id;
    }
}

