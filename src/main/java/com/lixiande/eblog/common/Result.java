package com.lixiande.eblog.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {
    private Object object;
    private String Code;
    private String msg;

    public Result(Object object, String code, String msg) {
        this.object = object;
        Code = code;
        this.msg = msg;
    }

    public Result(Object object, String msg) {
        this.object = object;
        this.msg = msg;
    }

    public static Result succ(Object object, String msg, String code){
        System.out.println("--------------------success---------------------");
        return new Result(object,msg,code);
    }
    public static Result fail(Object object, String msg, String code){
        System.out.println("---------------------fail-----------------------");
        return new Result(object,msg,code);
    }
}
