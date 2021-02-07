package com.chenxi.investigation.domain.dao;

import com.chenxi.investigation.domain.model.Userrole;
import com.chenxi.investigation.domain.model.UserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserroleMapper {
    int countByExample(UserroleExample example);

    int deleteByExample(UserroleExample example);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    List<Userrole> selectByExample(UserroleExample example);

    int updateByExampleSelective(@Param("record") Userrole record, @Param("example") UserroleExample example);

    int updateByExample(@Param("record") Userrole record, @Param("example") UserroleExample example);
}