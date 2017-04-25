package com.springboot.thrsky.girl.enums;

/**
 * 枚举
 * Created by thRShy on 2017/4/25.
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    SMALL_GIRL(100,"小学"),
    MIDDLE_GIRL(101,"初中"),
    HIGH_GIRL(1,"成功");

    private Integer code;

    private String msg;


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
