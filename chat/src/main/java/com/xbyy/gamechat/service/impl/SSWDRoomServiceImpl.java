package com.xbyy.gamechat.service.impl;

import com.xbyy.gamechat.mapper.SSWDRoomMapper;
import com.xbyy.gamechat.pojo.dto.SSWDRoomParam;
import com.xbyy.gamechat.pojo.entity.GameRoom;
import com.xbyy.gamechat.pojo.entity.User;
import com.xbyy.gamechat.service.SSWDRoomService;
import com.xbyy.gamechat.utils.ResultBody;
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
