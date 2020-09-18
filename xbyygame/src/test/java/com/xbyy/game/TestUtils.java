package com.xbyy.game;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class TestUtils {
    public static void main(String[] args) {
        Long dt = (new Date()).getTime();
        String pre8 = Long.toHexString(dt/1000).substring(0, 8);
        String mid3 =  dt.toString().substring(10);
        String last5 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println(pre8 + mid3 + last5);
    }
}
