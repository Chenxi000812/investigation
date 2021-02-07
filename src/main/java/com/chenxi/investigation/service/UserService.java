package com.chenxi.investigation.service;

import com.chenxi.investigation.domain.dao.SysrolesMapper;
import com.chenxi.investigation.domain.dao.SysuserMapper;
import com.chenxi.investigation.domain.dao.UserroleMapper;
import com.chenxi.investigation.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    SysuserMapper sysuserMapper;
    @Autowired
    SysrolesMapper sysrolesMapper;
    @Autowired
    UserroleMapper userroleMapper;

    private Sysuser queryUser(String username){
        SysuserExample sysuserExample = new SysuserExample();
        SysuserExample.Criteria criteria = sysuserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Sysuser> sysusers = sysuserMapper.selectByExample(sysuserExample);
        if (sysusers.size()!=1){
            return null;
        }
        Sysuser sysuser = sysusers.get(0);
        UserroleExample userroleExample = new UserroleExample();
        UserroleExample.Criteria criteria1 = userroleExample.createCriteria();
        criteria1.andUidEqualTo(sysuser.getId());
        List<Userrole> userroles = userroleMapper.selectByExample(userroleExample);
        SysrolesExample sysrolesExample = new SysrolesExample();
        SysrolesExample.Criteria criteria2 = sysrolesExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (Userrole u : userroles){
            list.add(u.getRid());
        }
        criteria2.andIdIn(list);
        List<Sysroles> sysroles = sysrolesMapper.selectByExample(sysrolesExample);
        sysuser.setSysroles(sysroles);
        return sysuser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return queryUser(username);
    }
}
