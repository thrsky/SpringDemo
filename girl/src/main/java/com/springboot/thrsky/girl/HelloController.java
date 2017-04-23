package com.springboot.thrsky.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thRShy on 2017/4/23.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return girlProperties.getCupSize();
    }
}
