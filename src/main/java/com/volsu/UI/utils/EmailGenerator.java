package com.volsu.UI.utils;

import java.util.Random;

public class EmailGenerator {

    private static String charSet = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int emailLength = 10;

    // генерация случайного email
    public static String createEmail() {

        String randomEmail = "";
        Random rnd = new Random();

        while (randomEmail.length() < emailLength) {
            int index = rnd.nextInt(charSet.length());
            randomEmail += charSet.charAt(index);
        }

        randomEmail += "@mail.example";
        return randomEmail;
    }
}
