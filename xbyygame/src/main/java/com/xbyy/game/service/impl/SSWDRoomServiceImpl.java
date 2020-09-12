package com.xbyy.game.service.impl;

import com.xbyy.game.mapper.SSWDRoomMapper;
import com.xbyy.game.pojo.dto.SSWDRoomParam;
import com.xbyy.game.pojo.entity.GameRoom;
import com.xbyy.game.pojo.entity.User;
import com.xbyy.game.service.SSWDRoomService;
import com.xbyy.game.service.SSWDWordService;
import com.xbyy.game.utils.RedisGameUtils;
import com.xbyy.game.utils.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.yeauty.pojo.Session;

import javax.annotation.Resource;

/**
 *  Service room service logic
 * @author moguang
 * @date 2020-09-13
 */
public class SSWDRoomServiceImpl extends BaseServiceImpl<SSWDRoomMapper, GameRoom> implements SSWDRoomService {
    @Resource
    private SSWDRoomMapper sswdRoomMapper;

    @Autowired
    private RedisGameUtils redisGameUtils;

    @Autowired
    private SSWDWordService sswdWordService;

    @Override
    public ResultBody createRoom(SSWDRoomParam roomParamDto, User user){
        // 据roomParamDto判断房间是否已经存在
        // 生成roomID
        // 往数据库插入一条房间记录
        // 往缓存redis插入一条房间记录
        // 返回结果
        return null;
    }

    @Override
    public void joinRoom(String senderId, String roomId, Session session){
        // 尝试从redis中获取room信息
        // redis无room信息，则尝试从数据库获取room信息，并同步到redis中
        // 从查询结果中获取房间成员、状态等信息
        // 符合加入条件，则更新redis中房间信息，并向所有人推送相关消息，并向自己返回房间关键信息
        // 不符合条件，返回错误码
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
    public void notifyPlayerDesc(String senderId, String roomId, String position,
                          String voteCount){
        // 确定下一位发言玩家
        // 如果有下一位发言玩家，房间状态改为开始发言描述，向所有人推送发言玩家信息
        // 如果没有下一位发言玩家，房间状态改为开始投票，向所有人推送投票相关信息
        // 如果是开始投票，定时30s后公布投票结果
    }

    @Override
    public void startVote(String curPosition, String roomId, String votePosition){
        // 获取当前投票者列表信息
        // 获取当前被投票者列表信息
        // 修改redis房间状态为投票中
        // 向其他所有用户推送投票相关信息
    }

    @Override
    public void findNeedVotePlayer(String senderId, String roomId, String position){
        // 查找状态在线、有资格投票的玩家列表
    }

    @Override
    public void findNeedDescPlayer(String senderId, String roomId, String position){
        // 查找状态在线、有资格发言的玩家列表
        // 根据上一个发言玩家，确定下一个发言的玩家
    }
}
