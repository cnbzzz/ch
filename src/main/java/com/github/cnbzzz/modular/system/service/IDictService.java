package com.github.cnbzzz.modular.system.service;

import com.github.cnbzzz.modular.system.model.Dict;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public interface IDictService extends IService<Dict> {

    /**
     * 添加字典
     */
    void addDict(String dictCode, String dictName, String dictTips, String dictValues);

    /**
     * 编辑字典
     */
    void editDict(Integer dictId, String dictCode, String dictName, String dictTips, String dicts);

    /**
     * 删除字典
     */
    void delteDict(String pcode);

    /**
     * 根据编码获取词典列表
     */
    List<Dict> selectByCode(String code);

    /**
     * 根据父类编码获取词典列表
     */
    List<Dict> selectByParentCode(String code);

    /**
     * 查询字典列表
     */
    List<Map<String, Object>> list(String conditiion);

}
