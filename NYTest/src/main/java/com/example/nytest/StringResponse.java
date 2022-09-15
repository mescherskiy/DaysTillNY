package com.example.nytest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StringResponse {
    private String resp;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StringResponse(String s) {
        this.resp = s;
    }

    @JsonCreator
    public StringResponse(@JsonProperty(required = false) String resp, @JsonProperty(required = true) Date date) {
        this.resp = resp;
        this.date = date;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }
}
