package com.xbyy.game.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xbyy.game.enums.GameFlagEnum;
import com.xbyy.game.enums.GameModeEnum;
import com.xbyy.game.enums.RoomStateEnum;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 *
 * @author moguang
 * @date 2020-09-10
 */
@Data
@TableName("sswd_room")
public class GameRoom implements Serializable,Cloneable {

    private static final long serialVersionUID = -153782320286949290L;
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    // 房间号、房间类型、房间状态
    protected String roomId;
    protected GameModeEnum mode; // 游戏模式 0-谁是卧底 1-白板卧底
    protected GameFlagEnum flag; // 房间flag 0-语音版 1-文字版
    protected RoomStateEnum state; // 房间state 0-normal 1-closed 2-banned

    // 创建者、更新者
    protected String createUser;
    protected String updateUser;

    // 创建日期、最近更新日期
    protected Date createAt;
    protected Date updateAt;

    // 参玩人数、卧底数、观看人数
    protected Integer playerNum;
    protected Integer wdNum;
    protected Integer viewerNum;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

//    public GameRoom clone() {
//        Class<?> classType = this.getClass();
//        GameRoom dest = new GameRoom();
//        for (Field field : classType.getDeclaredFields()) {
//            field.setAccessible(true);//设置可访问权限
//            Object value = field.get(this);//利用get方法取obj的值
//            field.set(dest, value);
//        }
//        return dest;
//    }
}
