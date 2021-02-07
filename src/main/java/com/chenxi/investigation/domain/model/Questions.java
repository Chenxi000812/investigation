package com.chenxi.investigation.domain.model;

import java.util.Date;
import java.util.List;

public class Questions {
    private Long id;

    private String caption;

    private Integer type;

    private Date createtime;

    private Integer questionnaireid;

    private List<Options> options;

    public Questions(Long id, String caption, Integer type, Date createtime, Integer questionnaireid) {
        this.id = id;
        this.caption = caption;
        this.type = type;
        this.createtime = createtime;
        this.questionnaireid = questionnaireid;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public Questions() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getQuestionnaireid() {
        return questionnaireid;
    }

    public void setQuestionnaireid(Integer questionnaireid) {
        this.questionnaireid = questionnaireid;
    }
}