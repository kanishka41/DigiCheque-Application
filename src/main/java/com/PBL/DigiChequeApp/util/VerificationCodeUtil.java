package com.PBL.DigiChequeApp.util;

import java.util.Random;

public class VerificationCodeUtil {

    public static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);  // Generates a random 6-digit code
        return String.valueOf(code);
    }
}
