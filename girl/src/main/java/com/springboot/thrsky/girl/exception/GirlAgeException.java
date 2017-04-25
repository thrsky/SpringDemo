package com.springboot.thrsky.girl.exception;

import com.springboot.thrsky.girl.enums.ResultEnum;

/**
 * Created by thRShy on 2017/4/25.
 */
public class GirlAgeException extends RuntimeException{

    private Integer code;

    public GirlAgeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
