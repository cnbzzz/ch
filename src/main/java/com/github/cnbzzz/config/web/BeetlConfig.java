package com.github.cnbzzz.config.web;

import com.github.cnbzzz.config.properties.BeetlProperties;
import com.github.cnbzzz.core.beetl.BeetlConfiguration;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This file is part of ch Project
 * Created by cnbzzz (cnbzzz@126.com) on 2018/12/26 16:03
 * Copyright (c) 2018 github.com/cnbzzz
 */
@Configuration
public class BeetlConfig {

    @Autowired
    BeetlProperties beetlProperties;

    /**
     * beetl的配置
     */
    @Bean(initMethod = "init")
    public BeetlConfiguration beetlConfiguration() {
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlConfig.class.getClassLoader(), beetlProperties.getPrefix()));
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        return beetlConfiguration;
    }

    /**
     * beetl的视图解析器
     */
    @Bean
    public BeetlSpringViewResolver beetlViewResolver() {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(beetlConfiguration());
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        return beetlSpringViewResolver;
    }
}
