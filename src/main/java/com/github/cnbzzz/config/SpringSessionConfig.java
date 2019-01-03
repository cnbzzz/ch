package com.github.cnbzzz.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)  //session过期时间  如果部署多机环境,需要打开注释
@ConditionalOnProperty(prefix = "ch", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfig {

}
