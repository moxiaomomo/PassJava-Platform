package com.xbyy.game.service;

import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.utils.ResultBody;
import org.yeauty.pojo.Session;

public interface SSWDRoomService {
  // 此处User应该用common中user
  public ResultBody createRoom(SSWDRoomParam roomParamDto, User user);

  public ResultBody joinRoom(String senderId, String roomId, Session session)
      throws CloneNotSupportedException;

  public void exitRoom(Session curSession);

  public void prepareGame();

  public void startGame();

  public void startDesc();

  public void startVote();

  public void endVote();

  public void voteOne(String curPosition, String roomId, String votePosition);

  public void endGame();

  public void findNeedVotePlayer(String roomId);

  public void findNeedDescPlayer(String roomId);
}
