/**  * This file is part of ch Project  * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03  * Copyright (c) 2018 github.com/cnbzzz  */
package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class UserDict extends AbstractDictMap {

    @Override
    public void init() {
        put("userId", "账号");
        put("avatar", "头像");
        put("account", "账号");
        put("name", "名字");
        put("birthday", "生日");
        put("sex", "性别");
        put("email", "电子邮件");
        put("phone", "电话");
        put("roleid", "角色名称");
        put("deptid", "部门名称");
        put("roleIds", "角色名称集合");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("sex", "getSexName");
        putFieldWrapperMethodName("deptid", "getDeptName");
        putFieldWrapperMethodName("roleid", "getSingleRoleName");
        putFieldWrapperMethodName("userId", "getUserAccountById");
        putFieldWrapperMethodName("roleIds", "getRoleName");
    }
}
