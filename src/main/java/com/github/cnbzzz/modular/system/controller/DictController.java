package com.github.cnbzzz.modular.system.controller;

import com.github.cnbzzz.core.common.annotion.BussinessLog;
import com.github.cnbzzz.core.common.annotion.Permission;
import com.github.cnbzzz.core.common.constant.Const;
import com.github.cnbzzz.core.common.constant.dictmap.DictMap;
import com.github.cnbzzz.core.common.constant.factory.ConstantFactory;
import com.github.cnbzzz.core.common.exception.BizExceptionEnum;
import com.github.cnbzzz.core.log.LogObjectHolder;
import com.github.cnbzzz.modular.system.model.Dict;
import com.github.cnbzzz.modular.system.service.IDictService;
import com.github.cnbzzz.modular.system.warpper.DictWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {

    private String PREFIX = "/system/dict/";

    @Autowired
    private IDictService dictService;

    /**
     * 跳转到字典管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dict.html";
    }

    /**
     * 跳转到添加字典
     */
    @RequestMapping("/dict_add")
    public String deptAdd() {
        return PREFIX + "dict_add.html";
    }

    /**
     * 跳转到修改字典
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping("/dict_edit/{dictId}")
    public String deptUpdate(@PathVariable Integer dictId, Model model) {
        Dict dict = dictService.selectById(dictId);
        model.addAttribute("dict", dict);
        List<Dict> subDicts = dictService.selectList(new EntityWrapper<Dict>().eq("pcode", dict.getCode()));
        model.addAttribute("subDicts", subDicts);
        LogObjectHolder.me().set(dict);
        return PREFIX + "dict_edit.html";
    }

    /**
     * 新增字典
     *
     * @param dictValues 格式例如   "1:启用;2:禁用;3:冻结"
     */
    @BussinessLog(value = "添加字典记录", key = "dictName,dictValues", dict = DictMap.class)
    @RequestMapping(value = "/add")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object add(String dictCode, String dictTips, String dictName, String dictValues) {
        if (ToolUtil.isOneEmpty(dictCode, dictName, dictValues)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        this.dictService.addDict(dictCode, dictName, dictTips, dictValues);
        return SUCCESS_TIP;
    }

    /**
     * 获取所有字典列表
     */
    @RequestMapping(value = "/list")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.dictService.list(condition);
        return super.warpObject(new DictWarpper(list));
    }

    /**
     * 字典详情
     */
    @RequestMapping(value = "/detail/{dictId}")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object detail(@PathVariable("dictId") Integer dictId) {
        return dictService.selectById(dictId);
    }

    /**
     * 修改字典
     */
    @BussinessLog(value = "修改字典", key = "dictName,dictValues", dict = DictMap.class)
    @RequestMapping(value = "/update")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object update(Integer dictId, String dictCode, String dictName, String dictTips, String dictValues) {
        if (ToolUtil.isOneEmpty(dictId, dictCode, dictName, dictValues)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        dictService.editDict(dictId, dictCode, dictName, dictTips, dictValues);
        return SUCCESS_TIP;
    }

    /**
     * 删除字典记录
     */
    @BussinessLog(value = "删除字典记录", key = "dictId", dict = DictMap.class)
    @RequestMapping(value = "/delete")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object delete(@RequestParam Integer dictId) {

        //缓存被删除的名称
        Dict dict = ConstantFactory.me().getDict(dictId);
        if(dict != null) {
            String dictName = dict.getName() == null ? "" : dict.getName();
            LogObjectHolder.me().set(dictName);
            this.dictService.delteDict(dict.getCode());
        }

        return SUCCESS_TIP;
    }

}
