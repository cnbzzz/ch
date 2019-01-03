package cn.stylefeng.cnbzzz.multi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "aaa", type = IdType.AUTO)
    private Integer aaa;

    private String bbb;


    public Integer getAaa() {
        return aaa;
    }

    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    @Override
    public String toString() {
        return "Test{" +
                "aaa=" + aaa +
                ", bbb=" + bbb +
                "}";
    }
}
