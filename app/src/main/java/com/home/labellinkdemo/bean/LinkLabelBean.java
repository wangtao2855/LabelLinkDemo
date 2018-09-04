package com.home.labellinkdemo.bean;

/**
 * Created by wangtao on 2018/4/18.
 */

public class LinkLabelBean {

    private boolean select;

    private String str;

    public String getStr() {
        return str == null ? "" : str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
