package com.xbyy.game.mapper;

import com.xbyy.game.pojo.entity.GameRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 *  Mapper 接口
 * @author moguang
 * @date 2020-09-12
 */
@Mapper
public interface SSWDRoomMapper extends GameBaseMapper<GameRoom> {

    @Insert("insert into sswd_room(room_id,create_user,player_num) values(#{roomId},#{userID},#{playerNum})")
    int createRoom(String roomId, String userID, int playerNum);
}
