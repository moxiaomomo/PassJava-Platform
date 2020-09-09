package com.moxiaomomo.chat.dao;

import org.springframework.beans.factory.annotation.Value;

public interface ChatRedisDao {
//    public static final String gameChatChannel ="gameChat_Channel";
//    public static final String gameChatSocketOpenChannel="gameChatSocketOpen_Channel";

    /**
     *
     * Description : send game chat message <br>
     * Create Time: 2020年9月9日 <br>
     * Create by : xxx <br>
     *
     * @param channel
     * @param message
     */
    public void sendMessage(String channel,String message);

    public void sendMessageByOpen(String channel,String message);
}