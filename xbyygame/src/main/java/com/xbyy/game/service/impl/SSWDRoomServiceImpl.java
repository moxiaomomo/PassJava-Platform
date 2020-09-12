package com.xbyy.game.service.impl;

import com.xbyy.game.mapper.SSWDRoomMapper;
import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.GameRoom;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.service.SSWDRoomService;
import com.xbyy.game.utils.ResultBody;
import org.yeauty.pojo.Session;

public class SSWDRoomServiceImpl extends BaseServiceImpl<SSWDRoomMapper, GameRoom> implements SSWDRoomService {
    @Override
    public ResultBody createRoom(SSWDRoomParam roomParamDto, User user){
        return null;
    }

    @Override
    public void joinRoom(String senderId, String roomId, Session session){

    }

    @Override
    public void existRoom(Session curSession) {

    }

    @Override
    public void notifyPlayerDesc(String senderId, String roomId, String position,
                          String voteCount){

    }

    @Override
    public void startVote(String curPosition, String roomId, String votePosition){

    }

    @Override
    public void findNeedVotePlayer(String senderId, String roomId, String position){

    }
}
