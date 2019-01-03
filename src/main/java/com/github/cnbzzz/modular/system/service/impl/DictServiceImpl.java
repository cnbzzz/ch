package com.github.cnbzzz.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.github.cnbzzz.core.common.exception.BizExceptionEnum;
import com.github.cnbzzz.modular.system.dao.DictMapper;
import com.github.cnbzzz.modular.system.model.Dict;
import com.github.cnbzzz.modular.system.service.IDictService;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.github.cnbzzz.core.common.constant.factory.MutiStrFactory.*;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    @Resource
    private DictMapper dictMapper;

    @Override
    @Transactional
    public void addDict(String dictCode, String dictName, String dictTips, String dictValues) {
        //判断有没有该字典
        List<Dict> dicts = dictMapper.selectList(new EntityWrapper<Dict>().eq("code", dictCode).and().eq("pcode", 0));
        if (dicts != null && dicts.size() > 0) {
            throw new ServiceException(BizExceptionEnum.DICT_EXISTED);
        }

        //解析dictValues
        List<Map<String, String>> items = parseKeyValue(dictValues);

        //添加字典
        Dict dict = new Dict();
        dict.setName(dictName);
        dict.setCode(dictCode);
        dict.setTips(dictTips);
        dict.setNum(0);
        dict.setPcode("0");
        this.dictMapper.insert(dict);

        //添加字典条目
        for (Map<String, String> item : items) {
            String code = item.get(MUTI_STR_CODE);
            String name = item.get(MUTI_STR_NAME);
            String num = item.get(MUTI_STR_NUM);
            Dict itemDict = new Dict();
            itemDict.setPcode(dict.getCode());
            itemDict.setCode(code);
            itemDict.setName(name);

            try {
                itemDict.setNum(Integer.valueOf(num));
            } catch (NumberFormatException e) {
                throw new ServiceException(BizExceptionEnum.DICT_MUST_BE_NUMBER);
            }
            this.dictMapper.insert(itemDict);
        }
    }

    @Override
    @Transactional
    public void editDict(Integer dictId, String dictCode, String dictName, String dictTips, String dicts) {
        //删除之前的字典
        this.delteDict(dictCode);

        //重新添加新的字典
        this.addDict(dictCode, dictName, dictTips, dicts);
    }

    @Override
    @Transactional
    public void delteDict(String pcode) {
        //删除这个字典的子词典
        Wrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
        dictEntityWrapper = dictEntityWrapper.eq("pcode", pcode);
        dictMapper.delete(dictEntityWrapper);

        //删除这个词典
        dictMapper.delete(new Condition().eq("code", pcode));
    }

    @Override
    public List<Dict> selectByCode(String code) {
        return this.baseMapper.selectByCode(code);
    }

    @Override
    public List<Dict> selectByParentCode(String code) {
        return this.baseMapper.selectByParentCode(code);
    }


    @Override
    public List<Map<String, Object>> list(String conditiion) {
        return this.baseMapper.list(conditiion);
    }
}
