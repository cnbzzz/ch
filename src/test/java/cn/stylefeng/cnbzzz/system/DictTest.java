package cn.stylefeng.cnbzzz.system;

import cn.stylefeng.cnbzzz.base.BaseJunit;
import com.github.cnbzzz.modular.system.dao.DictMapper;
import com.github.cnbzzz.modular.system.service.IDictService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class DictTest extends BaseJunit {

    @Resource
    IDictService dictService;

    @Resource
    DictMapper dictMapper;

    @Test
    public void addTest() {
        String dictCode = "test1";
        String dictName = "字典测试";
        String dictTips = "这是一个字典测试";
        String dictValues = "1:测试1:1;2:测试2:2";
        dictService.addDict(dictCode, dictName, dictTips, dictValues);
    }

    @Test
    public void editTest() {
        dictService.editDict(16, "tes", "测试", "备注", "1:测试1:1;2:测试2:2");
    }

    @Test
    public void deleteTest() {
        this.dictService.delteDict("tes");
    }

    @Test
    public void listTest() {
        List<Map<String, Object>> list = this.dictMapper.list("性别");
        Assert.assertTrue(list.size() > 0);
    }
}
