package com.github.cnbzzz.core.common.constant.state;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public enum ExpenseState {

    SUBMITING(1, "待提交"),
    CHECKING(2, "待审核"),
    PASS(3, "审核通过"),
    UN_PASS(4, "未通过");

    int code;
    String message;

    ExpenseState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (ExpenseState s : ExpenseState.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
