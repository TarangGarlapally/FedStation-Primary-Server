package com.fedstation.FedStation.service;

import java.sql.Timestamp;
import java.util.Random;

public class HelperServices {

    public String generateKey() {
        //20 chars 
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
}
