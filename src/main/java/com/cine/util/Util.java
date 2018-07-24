package com.cine.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    public static List<String> getNextDays(int count) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
        Date endDate = calendar.getTime();

        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(start);
        List<String> nextDays = new ArrayList<>();
        while (!gCal.getTime().after(endDate)) {
            Date date = gCal.getTime();
            gCal.add(Calendar.DATE, 1);
            nextDays.add(simpleDateFormat.format(date));
        }
        return nextDays;
    }
}
