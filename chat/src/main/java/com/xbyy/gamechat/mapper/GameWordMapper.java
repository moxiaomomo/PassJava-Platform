package com.xbyy.gamechat.mapper;

import com.xbyy.gamechat.pojo.entity.SSWDWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper 接口
 * @author moguang
 * @date 2020-09-11
 */
@Mapper
public interface GameWordMapper extends GameBaseMapper<SSWDWord> {

    /**
     * 批量保存并更新词汇
     * @param busWordList
     * @return
     */
    boolean batchSaveWordAndUpdate(@Param("wordList") List<SSWDWord> busWordList);
}

