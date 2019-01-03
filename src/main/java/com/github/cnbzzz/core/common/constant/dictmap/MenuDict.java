/**  * This file is part of ch Project  * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03  * Copyright (c) 2018 github.com/cnbzzz  */
package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class MenuDict extends AbstractDictMap {

    @Override
    public void init() {
        put("menuId", "菜单id");
        put("id", "菜单id");
        put("code", "菜单编号");
        put("pcode", "菜单父编号");
        put("name", "菜单名称");
        put("icon", "菜单图标");
        put("url", "url地址");
        put("num", "菜单排序号");
        put("levels", "菜单层级");
        put("tips", "备注");
        put("status", "菜单状态");
        put("isopen", "是否打开");
        put("", "");
    }

    @Override
    protected void initBeWrapped() {

    }
}
