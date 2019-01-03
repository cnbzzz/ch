package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class DeleteDict extends AbstractDictMap {

    @Override
    public void init() {
        put("roleId", "角色名称");
        put("deptId", "部门名称");
        put("menuId", "菜单名称");
        put("dictId", "字典名称");
        put("noticeId", "标题");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("roleId", "getCacheObject");
        putFieldWrapperMethodName("deptId", "getCacheObject");
        putFieldWrapperMethodName("menuId", "getCacheObject");
        putFieldWrapperMethodName("dictId", "getCacheObject");
        putFieldWrapperMethodName("noticeId", "getCacheObject");

    }
}
