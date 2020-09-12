package com.xbyy.game.service.impl;

import com.alibaba.fastjson.JSON;
import com.xbyy.game.mapper.SSWDWordMapper;
import com.xbyy.game.pojo.entity.SSWDWord;
import com.xbyy.game.service.SSWDWordService;
import com.xbyy.game.utils.RedisGameUtils;
import com.xbyy.game.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *  Service sswd word service
 *
 * @author moguang
 * @date 2020-09-11
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SSWDWordServiceImpl extends BaseServiceImpl<SSWDWordMapper, SSWDWord> implements SSWDWordService {
    @Autowired
    private RedisGameUtils redisGameUtils;

    @Resource
    private SSWDWordMapper wordMapper;


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
