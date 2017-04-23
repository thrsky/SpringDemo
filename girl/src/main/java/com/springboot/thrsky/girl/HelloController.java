package com.springboot.thrsky.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thRShy on 2017/4/23.
 */

//@RestController = @Controller + @ResponseBody
//代表了该方法返回的数据用json封装
@RestController
public class HelloController {

    //spring自动加载对应的bean
    @Autowired
    private GirlProperties girlProperties;

    //url映射注解
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return girlProperties.getCupSize();
    }
}
