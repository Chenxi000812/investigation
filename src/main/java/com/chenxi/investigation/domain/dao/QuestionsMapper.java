package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Questions;
import com.chenxi.investigation.domain.model.QuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionsMapper {
    int countByExample(QuestionsExample example);

    int deleteByExample(QuestionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Questions record);

    int insertSelective(Questions record);

    List<Questions> selectByExample(QuestionsExample example);

    Questions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByExample(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);
}