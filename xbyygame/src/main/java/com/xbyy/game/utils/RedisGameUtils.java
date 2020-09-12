package com.xbyy.game.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbyy.game.consts.CommonConst;
import com.xbyy.game.pojo.dto.RoomInfoToRedis;
import com.xbyy.game.pojo.dto.UserInfoToRedis;
import com.xbyy.game.pojo.vo.RoomMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RedisGameUtils {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 保存用户信息到redis
     */
    public Boolean setUserInfoToRedis(UserInfoToRedis userInfoToRedis ){
        return redisUtils.hmset(CommonConst.REDIS_PRE_USER + userInfoToRedis.getId(),
                JSONObject.parseObject(JSON.toJSONString(userInfoToRedis), Map.class));
    }

    /**
     * 获取用户信息
     */
    public UserInfoToRedis getUserInfoToRedis(String userId ){
        try {
            Map<Object,Object> userObject = redisUtils.hmget(CommonConst.REDIS_PRE_USER + userId);
            if(userObject != null && userObject.size()>0){
                return JsonUtils.convertBean(userObject,UserInfoToRedis.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }

    /**
     * 保存房间信息到redis -2:房间满了
     */
    public boolean setRoomInfoToRedis(RoomInfoToRedis roomInfoToRedis){
        return redisUtils.hmset(CommonConst.REDIS_PRE_ROOM + roomInfoToRedis.getRoomId(),
                (Map<String, Object>) JsonUtils.objectToMap(roomInfoToRedis));
    }

    /**
     * 获取redis中房间信息
     */
    public RoomInfoToRedis getRoomInfoToRedis(String roomId){
        try {
            Map<Object, Object> objectMap = redisUtils.hmget(CommonConst.REDIS_PRE_ROOM + roomId);
            if(objectMap != null && objectMap.size()>0){
                return JsonUtils.convertBean(objectMap,RoomInfoToRedis.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取房间成员信息
     */
    public List<RoomMemberVo> getRoomMemberToRedis(String roomId){
        List<RoomMemberVo> roomMemberVoList = new ArrayList<>();
        try {
            Cursor<Map.Entry<Object, Object>> cursor = redisUtils.scan(CommonConst.REDIS_PRE_ROOM_MEMBER + roomId);
            while (cursor.hasNext()) {
                Map.Entry<Object, Object> map = cursor.next();
                RoomMemberVo roomMemberVo = JsonUtils.convertBean(map.getValue(),RoomMemberVo.class);
                roomMemberVoList.add(roomMemberVo);
            }
            if(roomMemberVoList != null && roomMemberVoList.size()>0){
                //排序并输出
                return roomMemberVoList.stream()
                        .sorted(Comparator.comparing((RoomMemberVo r) -> r.getPosition()))
                        .collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取房间单个成员信息
     */
    public RoomMemberVo getOneRoomMemberToRedis(String roomId,String position){
        try {
            Object object = redisUtils.hget(CommonConst.REDIS_PRE_ROOM_MEMBER + roomId,position);
            if(object != null){
                return JsonUtils.convertBean(object,RoomMemberVo.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存房间成员信息
     */
    public Boolean setRoomMemberToRedis(String roomId,RoomMemberVo roomMemberVo,String position){
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put(position,roomMemberVo);
        return redisUtils.hmset(CommonConst.REDIS_PRE_ROOM_MEMBER + roomId,hashMap);
    }

    /**
     * 删除房间指定位置成员信息
     */
    public void removeRoomMemberToRedis(String roomId,String position){
        redisUtils.hdel(CommonConst.REDIS_PRE_ROOM_MEMBER + roomId,position);
    }

    /**
     * 删除房间所有位置成员信息
     */
    public void clearRoomMemberToRedis(String roomId,Object... item){
        redisUtils.hdel(CommonConst.REDIS_PRE_ROOM_MEMBER + roomId,item);
    }

    /**
     * 删除房间所有位置成员信息
     */
    public Object getNumAndRemove(String type){
        return redisUtils.getFirstAndRemove(CommonConst.REDIS_PRE_NUM_LIBRARY + type);
    }


    /**
     * 批量插入数据到redis
     * @param stringList
     * @param type
     * @return
     */
    public Boolean batchInsertRedis(List<String> stringList,String type){
        return redisUtils.batchInsertRedis(stringList,type);
    }

    /**
     * 查询词汇
     */
    public Object getNewWord(){
        return redisUtils.getRandomObject(CommonConst.REDIS_PRE_WORD_LIBRARY);
    }

}