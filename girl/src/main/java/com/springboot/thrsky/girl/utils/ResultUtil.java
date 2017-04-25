package com.springboot.thrsky.girl.utils;

import com.springboot.thrsky.girl.dto.Result;

/**
 * Created by thRShy on 2017/4/25.
 */
public class ResultUtil {


    /**
     *  返回成功的Result
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     *
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * Result失败的util
     * @param code
     * @param msg
     * @return
     */
    public static Result failed(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
