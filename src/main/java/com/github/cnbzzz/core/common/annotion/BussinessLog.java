package com.github.cnbzzz.core.common.annotion;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;
import com.github.cnbzzz.core.common.constant.dictmap.base.SystemDict;

import java.lang.annotation.*;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {

    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "id";

    /**
     * 字典(用于查找key的中文名称和字段的中文名称)
     */
    Class<? extends AbstractDictMap> dict() default SystemDict.class;
}
