package com.github.cnbzzz.core.util;

import com.github.cnbzzz.config.properties.ChProperties;
import cn.stylefeng.roses.core.util.SpringContextHolder;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(ChProperties.class).getKaptchaOpen();
    }
}