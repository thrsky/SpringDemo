package com.springboot.thrsky.girl.handle;

import com.springboot.thrsky.girl.dto.Result;
import com.springboot.thrsky.girl.exception.GirlAgeException;
import com.springboot.thrsky.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by thRShy on 2017/4/25.
 */

//异常捕获类
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ageHandle(Exception e){
        if(e instanceof GirlAgeException){
            GirlAgeException girlAgeException=(GirlAgeException) e;
            return ResultUtil.failed(girlAgeException.getCode(),girlAgeException.getMessage());
        }
        else{
            logger.info("[系统异常]:{}",e);
            return ResultUtil.failed(-1,"未知错误");
        }

    }

}

