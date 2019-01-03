/**  * This file is part of ch Project  * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03  * Copyright (c) 2018 github.com/cnbzzz  */
package com.github.cnbzzz.modular.system.warpper;

import cn.hutool.core.util.StrUtil;
import com.github.cnbzzz.core.common.constant.factory.ConstantFactory;
import com.github.cnbzzz.modular.system.model.Dict;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class DictWarpper extends BaseControllerWrapper {

    public DictWarpper(Map<String, Object> single) {
        super(single);
    }

    public DictWarpper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public DictWarpper(Page<Map<String, Object>> page) {
        super(page);
    }

    public DictWarpper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        String code = map.get("code").toString();
        List<Dict> dicts = ConstantFactory.me().findInDict(code);
        if (dicts != null) {
            for (Dict dict : dicts) {
                detail.append(dict.getCode() + ":" + dict.getName() + ",");
            }
            map.put("detail", StrUtil.removeSuffix(detail.toString(), ","));
        }
    }
}
