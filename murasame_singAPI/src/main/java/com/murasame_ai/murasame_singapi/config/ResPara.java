package com.murasame_ai.murasame_singapi.config;

import java.util.List;

public class ResPara {
    private String from;
    private String to;
    private List<message> trans_result;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<message> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<message> trans_result) {
        this.trans_result = trans_result;
    }
    public class message{
        private String src;
        private String dst;

        public void setDrom(String dst) {
            this.dst = dst;
        }

        public String getDst() {
            return dst;
        }
        public void setSrc(String src) {
            this.src = src;
        }

        public String getSrc() {
            return src;
        }
    }
}
