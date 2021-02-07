package com.chenxi.investigation.domain.model;

public class Options {
    private Long id;

    private String val;

    private Long questionid;

    public Options(Long id, String val, Long questionid) {
        this.id = id;
        this.val = val;
        this.questionid = questionid;
    }

    public Options() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }
}