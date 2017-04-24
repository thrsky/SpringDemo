package com.springboot.thrsky.girl.Controller;

import com.springboot.thrsky.girl.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thRShy on 2017/4/23.
 */

//@RestController = @Controller + @ResponseBody
//代表了该方法返回的数据用json封装
@RestController
//在类上也可以用@RequestMapping
//比如 @RequestMapping(value="/user/")  那么配合上下面方法上的注解，下面的方法就要用/user/hello 或 /user/hi 来请求了
public class HelloController {

    //spring自动加载对应的bean
    @Autowired
    private GirlProperties girlProperties;

    //url映射注解
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return girlProperties.getCupSize();
    }

    //@PathVairable 获取URL中的值
    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") int id){
        return "id:"+id;
    }

    //如果URL为传统的/user?id=100
    //那我们该怎么获取这个ID值呢?
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",
            required = false,//是否必须要传入参数
            defaultValue = "0"//默认值
    ) Integer myid){
        return "id:"+myid;
    }

    //@GetMapping = @RequsetMapping + method = RequestMethod.GET
    //@PostMapping 同理
}
