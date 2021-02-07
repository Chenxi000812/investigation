package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Options;
import com.chenxi.investigation.domain.model.OptionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionsMapper {
    int countByExample(OptionsExample example);

    int deleteByExample(OptionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Options record);

    int insertSelective(Options record);

    List<Options> selectByExample(OptionsExample example);

    Options selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByExample(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}