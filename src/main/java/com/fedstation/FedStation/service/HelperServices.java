package com.fedstation.FedStation.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

import com.fedstation.FedStation.entity.Project;

public class HelperServices {

    public String generateKey() {
        // 20 chars
        return Long.toString((new Timestamp(System.currentTimeMillis())).getTime()) + getSaltString();
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public Long getNextAggregationTimeStamp(Project project) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + Integer.parseInt(project.getTriggerEvery().toString()));
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, (Integer.parseInt(project.getStartAtTime()) + 2) % 24);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTimeInMillis() / 1000;
    }

    public Long getHourTimeStamp(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp*1000);
        cal.add(Calendar.HOUR, 1);
        return cal.getTimeInMillis() / 1000;
    }
    
}
