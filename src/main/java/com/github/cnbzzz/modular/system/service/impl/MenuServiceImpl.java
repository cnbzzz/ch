package com.github.cnbzzz.modular.system.service.impl;

import com.github.cnbzzz.core.common.node.MenuNode;
import com.github.cnbzzz.core.common.node.ZTreeNode;
import com.github.cnbzzz.modular.system.dao.MenuMapper;
import com.github.cnbzzz.modular.system.model.Menu;
import com.github.cnbzzz.modular.system.service.IMenuService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    @Transactional
    public void delMenu(Long menuId) {

        //删除菜单
        this.menuMapper.deleteById(menuId);

        //删除关联的relation
        this.menuMapper.deleteRelationByMenu(menuId);
    }

    @Override
    @Transactional
    public void delMenuContainSubMenus(Long menuId) {

        Menu menu = menuMapper.selectById(menuId);

        //删除当前菜单
        delMenu(menuId);

        //删除所有子菜单
        Wrapper<Menu> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pcodes", "%[" + menu.getCode() + "]%");
        List<Menu> menus = menuMapper.selectList(wrapper);
        for (Menu temp : menus) {
            delMenu(temp.getId());
        }
    }

    @Override
    public List<Map<String, Object>> selectMenus(String condition, String level) {
        return this.baseMapper.selectMenus(condition, level);
    }

    @Override
    public List<Long> getMenuIdsByRoleId(Integer roleId) {
        return this.baseMapper.getMenuIdsByRoleId(roleId);
    }

    @Override
    public List<ZTreeNode> menuTreeList() {
        return this.baseMapper.menuTreeList();
    }

    @Override
    public List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds) {
        return this.baseMapper.menuTreeListByMenuIds(menuIds);
    }

    @Override
    public int deleteRelationByMenu(Long menuId) {
        return this.baseMapper.deleteRelationByMenu(menuId);
    }

    @Override
    public List<String> getResUrlsByRoleId(Integer roleId) {
        return this.baseMapper.getResUrlsByRoleId(roleId);
    }

    @Override
    public List<MenuNode> getMenusByRoleIds(List<Integer> roleIds) {
        return this.baseMapper.getMenusByRoleIds(roleIds);
    }
}
