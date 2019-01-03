package cn.stylefeng.cnbzzz.system;

import cn.stylefeng.cnbzzz.base.BaseJunit;
import com.github.cnbzzz.modular.system.dao.MenuMapper;
import com.github.cnbzzz.modular.system.model.Menu;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Stack;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class MenuTest extends BaseJunit {

    @Autowired
    MenuMapper menuMapper;

    /**
     * 初始化pcodes
     *
     * @author bzzz
     * @Date 2017/6/13 21:24
     */
    @Test
    public void generatePcodes() {
        List<Menu> menus = menuMapper.selectList(null);
        for (Menu menu : menus) {
            if ("0".equals(menu.getPcode()) || null == menu.getPcode()) {
                menu.setPcodes("[0],");
            } else {
                StringBuffer sb = new StringBuffer();
                Menu parentMenu = getParentMenu(menu.getCode());
                sb.append("[0],");
                Stack<String> pcodes = new Stack<>();
                while (null != parentMenu.getPcode()) {
                    pcodes.push(parentMenu.getCode());
                    parentMenu = getParentMenu(parentMenu.getPcode());
                }
                int pcodeSize = pcodes.size();
                for (int i = 0; i < pcodeSize; i++) {
                    String code = pcodes.pop();
                    if (code.equals(menu.getCode())) {
                        continue;
                    }
                    sb.append("[" + code + "],");
                }

                menu.setPcodes(sb.toString());
            }
            menu.updateById();
        }
    }

    private Menu getParentMenu(String code) {
        Wrapper<Menu> wrapper = new EntityWrapper<Menu>();
        wrapper = wrapper.eq("code", code);
        List<Menu> menus = menuMapper.selectList(wrapper);
        if (menus == null || menus.size() == 0) {
            return new Menu();
        } else {
            return menus.get(0);
        }
    }
}
