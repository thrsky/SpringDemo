package com.springboot.thrsky.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by thRShy on 2017/4/23.
 */
//要注入配置  要加上component注解
@Component
//获取前缀是girl的配置
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;

    private int age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
