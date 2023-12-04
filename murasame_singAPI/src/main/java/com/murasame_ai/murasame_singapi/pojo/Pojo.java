package com.murasame_ai.murasame_singapi.pojo;

public class Pojo {
    private String text;
    private String id;

    public Pojo(String text, String id) {
        this.text = text;
        this.id = id;
    }

    public Pojo() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "text='" + text + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
