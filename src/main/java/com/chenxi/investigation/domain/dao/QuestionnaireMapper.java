package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Questionnaire;
import com.chenxi.investigation.domain.model.QuestionnaireExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface QuestionnaireMapper {
    int countByExample(QuestionnaireExample example);

    int deleteByExample(QuestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    List<Questionnaire> selectByExample(QuestionnaireExample example);

    Questionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

    int updateByExample(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);

    Questionnaire findByUrl(String url);
}