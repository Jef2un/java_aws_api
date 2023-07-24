package com.jeffnalex.exception;

import com.jeffnalex.result.PageResult;

public class BaseException extends RuntimeException{
    public BaseException(){}
    public BaseException(String msg){super(msg);}
}
