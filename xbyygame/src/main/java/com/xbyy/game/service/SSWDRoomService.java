package com.xbyy.game.service;

import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.utils.ResultBody;
import org.yeauty.pojo.Session;

public interface SSWDRoomService {
    // 此处User应该用common中user
    public ResultBody createRoom(SSWDRoomParam roomParamDto, User user);

    public ResultBody joinRoom(String senderId, String roomId, Session session) throws CloneNotSupportedException;

    public void exitRoom(Session curSession);

    public void notifyPlayerDesc(String senderId, String roomId, String position,
                          String voteCount);

    public void startVote(String curPosition, String roomId, String votePosition);

    public void findNeedVotePlayer(String senderId, String roomId, String position);

    public void findNeedDescPlayer(String senderId, String roomId, String position);
}
