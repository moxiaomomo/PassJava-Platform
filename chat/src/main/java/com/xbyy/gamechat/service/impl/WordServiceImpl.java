package com.xbyy.gamechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xbyy.gamechat.mapper.GameWordMapper;
import com.xbyy.gamechat.pojo.entity.SSWDWord;
import com.xbyy.gamechat.service.WordService;
import com.xbyy.gamechat.utils.RedisGameUtils;
import com.xbyy.gamechat.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private GameWordMapper wordMapper;


    /**
     * 随机获取新的词汇
     * 输入房间号 用于 保存指定房间出现过的词汇
     * @param roomId
     * @return
     */
    @Override
    public ResultBody queryNewWord(String roomId) {
        try{
            Object object = redisGameUtils.getNewWord();
            log.info("redis查询获取到的词汇:{}", object);
            if(null != object){
                return ResultBody.ok().msg(object.toString());
            } else {
//                QueryWrapper<SSWDWord> queryWrapper = new QueryWrapper<>();
//                queryWrapper.lambda()
//                        .eq(SSWDWord::getSynStatus, 1);
//                List<SSWDWord> sswds = wordMapper.selectList(queryWrapper);
                List<SSWDWord> sswds = wordMapper.queryAll();
                if(sswds != null && sswds.size()>0){
                    log.info("db查询获取到的词汇cnt:{}", sswds.size());
                    return ResultBody.ok().data(JSON.toJSONString(sswds.get(0)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultBody.failed().msg("no available words");
    }
}
