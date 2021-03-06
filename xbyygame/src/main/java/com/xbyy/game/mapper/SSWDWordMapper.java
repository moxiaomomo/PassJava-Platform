package com.xbyy.game.mapper;

import com.xbyy.game.pojo.entity.SSWDWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper 接口
 * @author moguang
 * @date 2020-09-11
 */
@Mapper
public interface SSWDWordMapper extends GameBaseMapper<SSWDWord> {

    /**
     * 批量保存并更新词汇
     * @param busWordList
     * @return
     */
    boolean batchSaveWordAndUpdate(@Param("wordList") List<SSWDWord> busWordList);

    List<SSWDWord> queryAll();
}

