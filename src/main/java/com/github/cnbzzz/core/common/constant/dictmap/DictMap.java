package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class DictMap extends AbstractDictMap {

    @Override
    public void init() {
        put("dictId", "字典名称");
        put("dictName", "字典名称");
        put("dictValues", "字典内容");
    }

    @Override
    protected void initBeWrapped() {

    }
}
