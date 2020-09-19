package com.xbyy.game.service.impl;

import com.xbyy.game.enums.GameStateEnum;
import com.xbyy.game.mapper.SSWDRoomMapper;
import com.xbyy.game.pojo.dto.RoomInfoToRedis;
import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.GameRoom;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.service.IDGenerateService;
import com.xbyy.game.service.SSWDRoomService;
import com.xbyy.game.service.SSWDWordService;
import com.xbyy.game.utils.RedisGameUtils;
import com.xbyy.game.utils.ResultBody;
import javax.annotation.Resource;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.yeauty.pojo.Session;

/**
 *  Service room service logic
 * @author moguang
 * @date 2020-09-13
 */
public class SSWDRoomServiceImpl
    extends BaseServiceImpl<SSWDRoomMapper, GameRoom>
    implements SSWDRoomService {
  @Resource private SSWDRoomMapper sswdRoomMapper;

  @Autowired private SSWDWordService sswdWordService;

  @Autowired private RedisGameUtils redisGameUtils;

  @Autowired private IDGenerateService idService;

  @Override
  public ResultBody createRoom(SSWDRoomParam roomParamDto, User user) {
    // 据roomParamDto判断房间是否已经存在

    // 生成roomID
    String roomId = idService.generateRoomID();

    // 往数据库插入一条房间记录
    sswdRoomMapper.createRoom(roomId, user.getId().toString(),
                              roomParamDto.getPlayerNum());

    // 往缓存redis插入一条房间记录
    RoomInfoToRedis roomInfo = new RoomInfoToRedis();
    roomInfo.setRoomId(roomId);
    roomInfo.setGameState(GameStateEnum.PREPARE);
    redisGameUtils.setRoomInfoToRedis(roomInfo);

    // 返回结果
    return ResultBody.ok().msg("创建成功").data(roomInfo);
  }

  @Override
  public ResultBody joinRoom(String senderId, String roomId, Session session)
      throws CloneNotSupportedException {
    // 尝试从redis中获取room信息
    RoomInfoToRedis roomInfo = redisGameUtils.getRoomInfoToRedis(roomId);
    // redis无room信息，则尝试从数据库获取room信息，并同步到redis中
    if (roomInfo == null) {
      GameRoom room = sswdRoomMapper.getRoom(roomId);
      if (room == null) {
        return ResultBody.failed().msg("No such room");
      }
      // 往缓存redis插入一条房间记录
      RoomInfoToRedis cacheInfo = new RoomInfoToRedis(room);
      cacheInfo.setGameState(GameStateEnum.PREPARE);
      redisGameUtils.setRoomInfoToRedis(cacheInfo);
    }
    // 从查询结果中获取房间成员、状态等信息
    // 符合加入条件，则更新redis中房间信息，并向所有人推送相关消息，并向自己返回房间关键信息
    // 不符合条件，返回错误码
    return ResultBody.ok().msg("加入成功");
  }

  @Override
  public void exitRoom(Session curSession) {
    // 删除用户对应的session信息
    // 如果游戏未开始，从redis房间中删除用户相关信息
    // 如果游戏已开始，标记用户已离开
    // 向房间所有人推送该用户退出信息
    // 如果当前为发言阶段，则推送消息，轮到下一个玩家发言
    // 如果所有玩家都退出了，修改该房间状态，清除所有玩家信息
  }

  @Override
  public void prepareGame() {
    // 玩家点击"加入游戏"后，表示已准备开始
    // 判断玩家是否已上麦，未上麦则提示无法加入游戏
    // 修改redis中房间成员状态
    // 返回当前上麦成员的准备状态
    // 如果所有麦位成员都已准备好，同时返回"可开始"提示
  }

  @Override
  public void startGame() {
    // 房主或管理员点击"开始游戏"后，表示游戏开始
    // 判断是否满足"游戏开始"条件，否则返回不满足开始相关提示
    // 修改房间游戏状态gameState
    // 初始化所有玩家状态
    // 返回"卧底词"等相关数据
  }

  @Override
  public void startDesc() {
    // 判断当前游戏状态是否可以开始描述阶段
    // 如果是首描，修改游戏状态为描述阶段
    // 获取即将进行描述的玩家，如果是首描可以随机选取一名正常玩家
    // 修改玩家状态
    // 返回玩家信息
  }

  @Override
  public void endGame() {
    // 根据目前所有玩家状态，生成游戏结果
    // 修改房间游戏状态
    // 清空房间玩家游戏状态
    // 返回游戏结果
  }

  @Override
  public void startVote() {
    // 获取当前投票者列表信息
    // 获取当前被投票者列表信息
    // 修改redis房间状态为投票中
    // 向其他所有用户推送投票相关信息
  }

  @Override
  public void endVote() {
    // 如果有玩家一直没投票，则投票超时后系统将关闭投票并统计投票结果
    // 修改房间游戏状态
    // 返回投票结果
  }

  @Override
  public void voteOne(String curPosition, String roomId, String votePosition) {
    // 判断是否有重复投票，重复则直接忽略
    // 修改游戏玩家状态
    // 返回投票结果信息
  }

  @Override
  public void findNeedVotePlayer(String roomId) {
    // 查找状态在线、有资格投票的玩家列表
  }

  @Override
  public void findNeedDescPlayer(String roomId) {
    // 查找状态在线、有资格发言的玩家列表
    // 根据上一个发言玩家，确定下一个发言的玩家
  }

  //    @Override
  //    public void notifyPlayerDesc(String senderId, String roomId, String
  //    position,
  //                                 String voteCount){
  //        // 确定下一位发言玩家
  //        //
  //        如果有下一位发言玩家，房间状态改为开始发言描述，向所有人推送发言玩家信息
  //        //
  //        如果没有下一位发言玩家，房间状态改为开始投票，向所有人推送投票相关信息
  //        // 如果是开始投票，定时30s后公布投票结果
  //    }
}
