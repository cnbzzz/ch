package com.github.cnbzzz.core.util;

import com.github.cnbzzz.config.properties.ChProperties;
import com.github.cnbzzz.core.common.constant.Const;
import com.github.cnbzzz.core.common.node.MenuNode;
import cn.stylefeng.roses.core.util.SpringContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class ApiMenuFilter extends MenuNode {

    public static List<MenuNode> build(List<MenuNode> nodes) {

        //如果关闭了接口文档,则不显示接口文档菜单
        ChProperties chProperties = SpringContextHolder.getBean(ChProperties.class);
        if (!chProperties.getSwaggerOpen()) {
            List<MenuNode> menuNodesCopy = new ArrayList<>();
            for (MenuNode menuNode : nodes) {
                if (Const.API_MENU_NAME.equals(menuNode.getName())) {
                    continue;
                } else {
                    menuNodesCopy.add(menuNode);
                }
            }
            nodes = menuNodesCopy;
        }

        return nodes;
    }

    public static void main(String[] args) {

    }
}
