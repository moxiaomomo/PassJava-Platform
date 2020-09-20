package com.xbyy.game.service.impl;

import com.xbyy.game.service.IDGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class IDGenerateServiceImpl implements IDGenerateService {
    @Override
    public String generateUUID(String type) {
        // TODO implement logic
        return "unimplemented";
    }

    // length(roomID)=16
    @Override
    public String generateRoomID() {
        Long dt = (new Date()).getTime();
        String pre8 = Long.toHexString(dt/1000).substring(0, 8);
        String mid3 =  dt.toString().substring(10);
        String last5 = RandomStringUtils.randomAlphanumeric(5);
        return pre8 + mid3 + last5;
    }
}
