package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Sysuser;
import com.chenxi.investigation.domain.model.SysuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysuserMapper {
    int countByExample(SysuserExample example);

    int deleteByExample(SysuserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    List<Sysuser> selectByExample(SysuserExample example);

    Sysuser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByExample(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);
}