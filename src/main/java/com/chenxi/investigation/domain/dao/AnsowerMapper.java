package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Ansower;
import com.chenxi.investigation.domain.model.AnsowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnsowerMapper {
    int countByExample(AnsowerExample example);

    int deleteByExample(AnsowerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ansower record);

    int insertSelective(Ansower record);

    List<Ansower> selectByExample(AnsowerExample example);

    Ansower selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ansower record, @Param("example") AnsowerExample example);

    int updateByExample(@Param("record") Ansower record, @Param("example") AnsowerExample example);

    int updateByPrimaryKeySelective(Ansower record);

    int updateByPrimaryKey(Ansower record);

    int insertList(@Param("ansowers") List<Ansower> ansowers);
}