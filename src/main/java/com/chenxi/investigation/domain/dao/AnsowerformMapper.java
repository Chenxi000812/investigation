package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Ansowerform;
import com.chenxi.investigation.domain.model.AnsowerformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnsowerformMapper {
    int countByExample(AnsowerformExample example);

    int deleteByExample(AnsowerformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ansowerform record);

    int insertSelective(Ansowerform record);

    List<Ansowerform> selectByExample(AnsowerformExample example);

    Ansowerform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ansowerform record, @Param("example") AnsowerformExample example);

    int updateByExample(@Param("record") Ansowerform record, @Param("example") AnsowerformExample example);

    int updateByPrimaryKeySelective(Ansowerform record);

    int updateByPrimaryKey(Ansowerform record);

}