package com.example.seckill.util;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;


@Component
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass) {
        String str = salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(0) + formPass + salt.charAt(1) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String salt) {
        String formPass = inputPassToFormPass(inputPass);
        return formPassToDBPass(formPass, salt);
    }

    public static void main(String[] args) {
        //defaa3ab50592bb25feb82d4608fdbb8
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass("defaa3ab50592bb25feb82d4608fdbb8", "1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }
}
