package com.github.cnbzzz.core.common.constant.state;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public enum LogType {

    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
