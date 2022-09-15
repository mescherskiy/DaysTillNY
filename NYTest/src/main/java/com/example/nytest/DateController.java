package com.example.nytest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping ("/")
public class DateController {
    private final DateService dateService;
    private long days = 3;

    private StringResponse stringResponse;

    public StringResponse getStringResponse() {
        return stringResponse;
    }

    public void setStringResponse(StringResponse stringResponse) {
        this.stringResponse = stringResponse;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping("count")
    public long counting(@RequestBody StringResponse obj) {
        setStringResponse(obj);
        long cnt = dateService.count(this.getStringResponse().getDate());
        setDays(cnt);
        return getDays();
    }

    @GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long daysLeft() {
        return getDays();
    }
}

