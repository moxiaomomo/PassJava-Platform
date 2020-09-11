package com.xbyy.gamechat.service.impl;

import com.xbyy.gamechat.mapper.GameWordMapper;
import com.xbyy.gamechat.pojo.entity.SSWDWord;
import com.xbyy.gamechat.service.WordService;
import com.xbyy.gamechat.utils.RedisGameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  服务实现类
 *
 * @author moguang
 * @date 2020-09-11
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class WordServiceImpl extends BaseServiceImpl<GameWordMapper, SSWDWord> implements WordService {
    @Autowired
    private RedisGameUtils redisGameUtils;

//    @Resource
//    private GameWordMapper wordMapper;


    /**
     * 随机获取新的词汇
     * 输入房间号 用于 保存指定房间出现过的词汇
     * @param roomId
     * @return
     */
    @Override
    public String queryNewWord(String roomId) {
        try{
            Object object = redisGameUtils.getNewWord();
            log.info("查询获取到的词汇:{}", object);
            if(null != object){
                return object.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
