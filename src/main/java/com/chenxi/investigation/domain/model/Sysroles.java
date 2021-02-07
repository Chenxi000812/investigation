package com.chenxi.investigation.domain.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

public class Sysroles implements GrantedAuthority {
    private Integer id;

    private String role;

    private String de;

    private Date createtime;

    public Sysroles(Integer id, String role, String de, Date createtime) {
        this.id = id;
        this.role = role;
        this.de = de;
        this.createtime = createtime;
    }

    public Sysroles() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de == null ? null : de.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}