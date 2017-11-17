package io.github.johnshen1990.javawebapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {
//    @Value("#{prop.nickname}")
    private String nickName;

//    @Value("#{prop.gender}")
    private String gender;

    public String getNickName() {
        return nickName;
    }

    public String getGender() {
        return gender;
    }
}
