package com.chenxi.investigation.domain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Sysuser implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private Integer status;

    private Date createtime;

    private List<Sysroles> sysroles;

    public Sysuser(Long id, String username, String password, Integer status, Date createtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createtime = createtime;
    }

    public void setSysroles(List<Sysroles> sysroles) {
        this.sysroles = sysroles;
    }

    public Sysuser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return sysroles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}