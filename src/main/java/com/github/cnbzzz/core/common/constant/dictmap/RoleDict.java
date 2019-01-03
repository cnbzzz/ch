/**  * This file is part of ch Project  * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03  * Copyright (c) 2018 github.com/cnbzzz  */
package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class RoleDict extends AbstractDictMap {

    @Override
    public void init() {
        put("roleId", "角色名称");
        put("num", "角色排序");
        put("pid", "角色的父级");
        put("name", "角色名称");
        put("deptid", "部门名称");
        put("tips", "备注");
        put("ids", "资源名称");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("pid", "getSingleRoleName");
        putFieldWrapperMethodName("deptid", "getDeptName");
        putFieldWrapperMethodName("roleId", "getSingleRoleName");
        putFieldWrapperMethodName("ids", "getMenuNames");
    }
}
