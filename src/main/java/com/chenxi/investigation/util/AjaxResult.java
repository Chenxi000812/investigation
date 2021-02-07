package com.chenxi.investigation.util;

public class AjaxResult {

    private int code = 0;
    private String msg = "";
    private long count = 0;
    private Object data = null;

    public static AjaxResult me(){
        return new AjaxResult();
    }

    public int getCode() {
        return code;
    }

    public AjaxResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public long getCount() {
        return count;
    }

    public AjaxResult setCount(long count) {
        this.count = count;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }
}
