package com.chenxi.investigation.domain.model;

import java.util.Date;

public class Ansowerform {
    private Long id;

    private Long userid;

    private Integer questionnaireid;

    private Date createtime;

    public Ansowerform(Long id, Long userid, Integer questionnaireid, Date createtime) {
        this.id = id;
        this.userid = userid;
        this.questionnaireid = questionnaireid;
        this.createtime = createtime;
    }

    public Ansowerform() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getQuestionnaireid() {
        return questionnaireid;
    }

    public void setQuestionnaireid(Integer questionnaireid) {
        this.questionnaireid = questionnaireid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}