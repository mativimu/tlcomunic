package com.tlcomunic.aut.util;

import java.security.MessageDigest;

public class PasswordHasher {

    public static String hash(String password) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            messageDigest.update(password.getBytes());

            byte[] hashedBytes = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : hashedBytes)
                stringBuilder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
