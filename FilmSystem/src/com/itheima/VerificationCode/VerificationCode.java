package com.itheima.VerificationCode;

import java.util.Random;

public class VerificationCode {
    //验证码
    public static final Random r = new Random();   //导包随机数

    /**验证码
     *
     * @param i 几位数
     * @return    随机数
     */
    public static String GetVerificationCode(int i){
        String codes="";
String code="abcdefghijklmnopqrstuvwsyzABCDEFGHIJKLMNOPQRSTUVWSYZ0123456789";
        for (int j = 0; j < i; j++) {
            char c = codes.charAt(r.nextInt(codes.length()));
           codes +=code;

        }
        return codes;
    }
}
