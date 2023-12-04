package com.murasame_ai.murasame_singapi.pojo;


public class Reply {
    private String rid;         //语料id
    private String content;     //回复文本
    private String keyword;     //关键字
    private String emotion;     //感情倾向

    public Reply(String content) {
        this.content = content;
    }

    public Reply() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid='" + rid + '\'' +
                ", content='" + content + '\'' +
                ", keyword='" + keyword + '\'' +
                ", emotion='" + emotion + '\'' +
                '}';
    }
}
