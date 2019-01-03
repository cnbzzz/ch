/**  * This file is part of ch Project  * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03  * Copyright (c) 2018 github.com/cnbzzz  */
package com.github.cnbzzz.core.common.constant.dictmap;

import com.github.cnbzzz.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class NoticeMap extends AbstractDictMap {

    @Override
    public void init() {
        put("title", "标题");
        put("content", "内容");
    }

    @Override
    protected void initBeWrapped() {
    }
}
