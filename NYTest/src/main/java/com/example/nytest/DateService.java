package com.example.nytest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;
import java.util.Date;

@Service
public class DateService {

    public long count (@RequestBody Date obj) {
        Calendar inputDate = Calendar.getInstance();
        inputDate.setTime(obj);
        int year = inputDate.get(Calendar.YEAR);
        Calendar newYear = Calendar.getInstance();
        newYear.set(year + 1, Calendar.JANUARY, 0);
        return ((newYear.getTimeInMillis() - inputDate.getTimeInMillis()) / 86400000);
    }

}
