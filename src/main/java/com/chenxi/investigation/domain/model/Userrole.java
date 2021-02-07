package com.chenxi.investigation.domain.model;

import java.util.Date;

public class Userrole {
    private Long uid;

    private Integer rid;

    private Date createtime;

    public Userrole(Long uid, Integer rid, Date createtime) {
        this.uid = uid;
        this.rid = rid;
        this.createtime = createtime;
    }

    public Userrole() {
        super();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}