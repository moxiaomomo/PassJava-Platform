package com.xbyy.gamechat.service;

import com.xbyy.gamechat.utils.ResultBody;

public interface WordService {
    ResultBody queryNewWord(String roomId);
}
