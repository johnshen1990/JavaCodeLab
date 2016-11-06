package io.github.johnshen1990.javacodelab.javabasic.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Author: zhun.shen
 * Date: 2016-11-03 08:53
 * Description:
 */
@Component
public class MyPropertiesBean {
    @Resource(name = "myProperties")
    private Properties myProperties;

    private String username;

    @Value("#{myProperties.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return myProperties.getProperty("username", "");
    }

    public String getUsername2(){
        return username;
    }



}

