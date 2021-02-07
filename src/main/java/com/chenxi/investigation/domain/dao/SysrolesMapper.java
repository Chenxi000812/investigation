package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Sysroles;
import com.chenxi.investigation.domain.model.SysrolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysrolesMapper {
    int countByExample(SysrolesExample example);

    int deleteByExample(SysrolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sysroles record);

    int insertSelective(Sysroles record);

    List<Sysroles> selectByExample(SysrolesExample example);

    Sysroles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sysroles record, @Param("example") SysrolesExample example);

    int updateByExample(@Param("record") Sysroles record, @Param("example") SysrolesExample example);

    int updateByPrimaryKeySelective(Sysroles record);

    int updateByPrimaryKey(Sysroles record);
}