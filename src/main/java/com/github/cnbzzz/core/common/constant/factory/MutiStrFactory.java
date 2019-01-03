package com.github.cnbzzz.core.common.constant.factory;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.roses.core.util.ToolUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class MutiStrFactory {

    /**
     * 每个条目之间的分隔符
     */
    public static final String ITEM_SPLIT = ";";

    /**
     * 属性之间的分隔符
     */
    public static final String ATTR_SPLIT = ":";

    /**
     * 拼接字符串的id
     */
    public static final String MUTI_STR_ID = "ID";

    /**
     * 拼接字符串的CODE
     */
    public static final String MUTI_STR_CODE = "CODE";

    /**
     * 拼接字符串的NAME
     */
    public static final String MUTI_STR_NAME = "NAME";

    /**
     * 拼接字符串的NUM
     */
    public static final String MUTI_STR_NUM = "NUM";

    /**
     * This file is part of ch Project
     * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
     * Copyright (c) 2018 github.com/cnbzzz
     */
    public static List<Map<String, String>> parseKeyValue(String mutiString) {
        if (ToolUtil.isEmpty(mutiString)) {
            return new ArrayList<>();
        } else {
            ArrayList<Map<String, String>> results = new ArrayList<>();
            String[] items = StrUtil.split(StrUtil.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(ATTR_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>();
                itemMap.put(MUTI_STR_CODE, attrs[0]);
                itemMap.put(MUTI_STR_NAME, attrs[1]);
                itemMap.put(MUTI_STR_NUM, attrs[2]);
                results.add(itemMap);
            }
            return results;
        }
    }
}
