package com.murasame_ai.murasame_singapi.config;

public class R {
    private String stateNum;
    private Object data;

    public R(String stateNum, Object data) {
        this.stateNum = stateNum;
        this.data = data;
    }

    public R(String stateNum) {
        this.stateNum = stateNum;
    }

    public String getStateNum() {
        return stateNum;
    }

    public void setStateNum(String stateNum) {
        this.stateNum = stateNum;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public R() {
    }
}
