package io.github.johnshen1990.javawebapp.properties;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

@Component
public class MyPropBean {

    @Resource
    private Properties prop;
    private String nickName;
    private String gender;

    @PostConstruct
    public void init() {
        nickName = prop.getProperty("nickname", "");
        gender = prop.getProperty("gender", "");
    }

    public String getNickName() {
        return nickName;
    }

    public String getGender() {
        return gender;
    }
}
