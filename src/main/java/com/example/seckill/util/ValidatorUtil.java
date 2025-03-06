package com.example.seckill.util;

import java.util.regex.Pattern;

public class ValidatorUtil {

    /**
     * 手机号码校验规则
     */
    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");
    public static boolean isMobile(String mobile) {
        if (mobile == null) {
            return false;
        }
        return mobile_pattern.matcher(mobile).matches();
    }

}