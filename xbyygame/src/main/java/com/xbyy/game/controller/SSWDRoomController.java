package com.xbyy.game.controller;

import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.service.SSWDRoomService;
import com.xbyy.game.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/v1/sswd/")
public class SSWDRoomController {
    @Autowired
    private SSWDRoomService roomService;

    @RequestMapping(value = "createRoom", method = RequestMethod.POST)
    public ResultBody createRoom(@RequestParam("userID") String userID,
                                 @RequestParam("roomName") String roomName,
                                 @RequestParam(value="roomFlag",required = false, defaultValue = "1") Integer roomFlag,
                                 @RequestParam(value="playerNum",required = false, defaultValue = "6") Integer playerNum
    ) {
        SSWDRoomParam param = new SSWDRoomParam();
        param.setRoomFlag(roomFlag);
        param.setRoomName(roomName);
        param.setPlayerNum(playerNum);

        User user = new User();
        user.setUserID(userID);
        return roomService.createRoom(param, user);
    }

}
