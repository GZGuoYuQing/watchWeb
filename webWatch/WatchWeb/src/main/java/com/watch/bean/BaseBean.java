package com.watch.bean;

import java.util.List;

/**
 * Created by xiao-kang on 2017/3/20.
 */
public class BaseBean  {
    private int id; // ID
    private String des ;// 描述

    private List<Watch> watches;  //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<Watch> getWatches() {
        return watches;
    }

    public void setWatches(List<Watch> watches) {
        this.watches = watches;
    }
}
