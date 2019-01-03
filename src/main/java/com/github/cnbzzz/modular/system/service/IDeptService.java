package com.github.cnbzzz.modular.system.service;

import com.github.cnbzzz.core.common.node.ZTreeNode;
import com.github.cnbzzz.modular.system.model.Dept;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public interface IDeptService extends IService<Dept> {

    /**
     * 删除部门
     */
    void deleteDept(Integer deptId);

    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();

    /**
     * 获取所有部门列表
     */
    List<Map<String, Object>> list(String condition);
}
