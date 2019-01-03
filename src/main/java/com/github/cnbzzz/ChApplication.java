package com.github.cnbzzz;

import cn.stylefeng.roses.core.config.WebAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 *
 * @author bzzz
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication(exclude = WebAutoConfiguration.class)
public class ChApplication {

    private final static Logger logger = LoggerFactory.getLogger(ChApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ChApplication.class, args);
        logger.info("ChApplication is success!");
    }
}
