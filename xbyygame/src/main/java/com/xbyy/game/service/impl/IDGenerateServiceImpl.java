package com.xbyy.game.service.impl;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class IDGenerateServiceImpl {
    public String generateUUID(String type) {
        // TODO implement logic
        return "unimplemented";
    }

    // legth(roomID)=16
    public String generateRoomID() {
        Long dt = (new Date()).getTime();
        String pre8 = Long.toHexString(dt/1000).substring(0, 8);
        String mid3 =  dt.toString().substring(10);
        String last5 = RandomStringUtils.randomAlphanumeric(5);
        return pre8 + mid3 + last5;
    }
}
