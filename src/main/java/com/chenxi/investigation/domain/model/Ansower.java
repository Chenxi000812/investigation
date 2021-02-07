package com.chenxi.investigation.domain.model;

public class Ansower {
    private Long id;

    private Long optionid;

    private String val;

    private Long formid;

    public Ansower(Long id, Long optionid, String val, Long formid) {
        this.id = id;
        this.optionid = optionid;
        this.val = val;
        this.formid = formid;
    }

    public Ansower() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOptionid() {
        return optionid;
    }

    public void setOptionid(Long optionid) {
        this.optionid = optionid;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public Long getFormid() {
        return formid;
    }

    public void setFormid(Long formid) {
        this.formid = formid;
    }
}