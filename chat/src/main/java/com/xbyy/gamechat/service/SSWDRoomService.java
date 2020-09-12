package com.xbyy.gamechat.service;

import com.xbyy.gamechat.pojo.dto.SSWDRoomParam;
import com.xbyy.gamechat.pojo.entity.User;
import com.xbyy.gamechat.utils.ResultBody;
import org.yeauty.pojo.Session;

public interface SSWDRoomService {
    // 此处User应该用common中user
    public ResultBody createRoom(SSWDRoomParam roomParamDto, User user);

    public void joinRoom(String senderId, String roomId, Session session);

    public void existRoom(Session curSession);

    public void notifyPlayerDesc(String senderId, String roomId, String position,
                          String voteCount);

    public void startVote(String curPosition, String roomId, String votePosition);

    public void findNeedVotePlayer(String senderId, String roomId, String position);
}
