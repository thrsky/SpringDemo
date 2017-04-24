package com.springboot.thrsky.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by thRShy on 2017/4/24.
 */

@Aspect  //切面
@Component  //把该类引入Spring容器中
public class HttpAspect {
    //日志
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    //切点 下面的方法其实没有什么实际的作用 也可能是我还没看出来用处
    @Pointcut("execution(public * com.springboot.thrsky.girl.Controller.GirlController.*(..))")
    public void girlist(){
    }
    //在下面的方法执行之前  先执行指定的方法
    @Before("girlist()")
    public void doBefore(JoinPoint joinPoint){
        //记录http请求

        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url

        logger.info("url={}",request.getRequestURL());
        // method
        logger.info("method={}",request.getMethod());

        //ip
        //如果出现IP获取出来为0:0:0:0:0:0:0:1的情况  ， 把访问请求时的localhost:8080/ 改为 127.0.0.1:8080即可
        logger.info("ip={}",request.getRemoteAddr());

        //目标类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("girlist()")
    public void doAfter(){
        logger.info("2222222222222222");//TODO
    }

    @AfterReturning(returning = "object",pointcut = "girlist()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }

}
