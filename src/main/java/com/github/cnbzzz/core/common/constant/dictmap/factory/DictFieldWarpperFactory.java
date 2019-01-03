package com.github.cnbzzz.core.common.constant.dictmap.factory;

import com.github.cnbzzz.core.common.constant.factory.ConstantFactory;
import com.github.cnbzzz.core.common.constant.factory.IConstantFactory;
import com.github.cnbzzz.core.common.exception.BizExceptionEnum;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

import java.lang.reflect.Method;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
public class DictFieldWarpperFactory {

    public static Object createFieldWarpper(Object parameter, String methodName) {
        IConstantFactory constantFactory = ConstantFactory.me();
        try {
            Method method = IConstantFactory.class.getMethod(methodName, parameter.getClass());
            return method.invoke(constantFactory, parameter);
        } catch (Exception e) {
            try {
                Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
                return method.invoke(constantFactory, Integer.parseInt(parameter.toString()));
            } catch (Exception e1) {
                throw new ServiceException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }

}
