package com.github.cnbzzz.config.properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

import static cn.stylefeng.roses.core.util.ToolUtil.getTempPath;

/**
 * guns项目配置
 *
 * @author bzzz
 * @Date 2017/5/23 22:31
 */
@Component
@ConfigurationProperties(prefix = ChProperties.PREFIX)
public class ChProperties {

    public static final String PREFIX = "ch";

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Boolean springSessionOpen = false;

    /**
     * session 失效时间（默认为30分钟 单位：秒）
     */
    private Integer sessionInvalidateTime = 30 * 60;

    /**
     * session 验证失效时间（默认为15分钟 单位：秒）
     */
    private Integer sessionValidationInterval = 15 * 60;

    public String getFileUploadPath() {
        //如果没有写文件上传路径,保存到临时目录
        if (StringUtils.isBlank(fileUploadPath)) {
            return getTempPath();
        } else {
            //当前目录
            String filePath = replaceUserDir(fileUploadPath + "/" + DateFormatUtils.format(new Date(), "yyyy/MM/dd"));

            //判断有没有结尾符,没有得加上
            if (!filePath.endsWith(File.separator)) {
                filePath = filePath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            File file = new File(filePath);
            if (!file.exists()){
                file.mkdirs();
            }
            return filePath;
        }
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Boolean getKaptchaOpen() {
        return kaptchaOpen;
    }

    public void setKaptchaOpen(Boolean kaptchaOpen) {
        this.kaptchaOpen = kaptchaOpen;
    }

    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }

    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }

    public Boolean getSpringSessionOpen() {
        return springSessionOpen;
    }

    public void setSpringSessionOpen(Boolean springSessionOpen) {
        this.springSessionOpen = springSessionOpen;
    }

    public Integer getSessionInvalidateTime() {
        return sessionInvalidateTime;
    }

    public void setSessionInvalidateTime(Integer sessionInvalidateTime) {
        this.sessionInvalidateTime = sessionInvalidateTime;
    }

    public Integer getSessionValidationInterval() {
        return sessionValidationInterval;
    }

    public void setSessionValidationInterval(Integer sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }

    private static String replaceUserDir(String str) {
        String USER_DIR = "user.dir";
        if(str.startsWith(USER_DIR)){
            str = StringUtils.replace(str, USER_DIR, System.getProperty(USER_DIR));
        }
        return str;
    }
}
