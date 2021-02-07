package com.chenxi.investigation.domain.model;

import java.util.Date;
import java.util.List;

public class Questionnaire {
    private Integer id;

    private String title;

    private Long createuser;

    private Date createtime;

    private Date updatetime;

    private Integer status;

    private String url;

    private List<Questions> questions;

    public Questionnaire(Integer id, String title, Long createuser, Date createtime, Date updatetime, Integer status, String url) {
        this.id = id;
        this.title = title;
        this.createuser = createuser;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.status = status;
        this.url = url;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public Questionnaire() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Long createuser) {
        this.createuser = createuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}