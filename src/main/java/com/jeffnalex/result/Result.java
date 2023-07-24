package com.jeffnalex.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 統一的結果返回
 * @param <T>
 */

@Data
public class Result<T> implements Serializable {
    private Integer code; // 1:成功 0: 失敗
    private String msg; // 錯誤訊息回傳
    private T data; // T為犯型

    public static <T> Result<T> success(){
        Result<T> result = new Result<T>();
        result.code = 1 ;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> success(T object){
        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = "success";
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result = new Result<T>();
        result.code = 0;
        result.msg = msg;
        return result;

    }




}
