package com.exception;

public class BizException extends RuntimeException{
    public BizException() {
        super("지원하지 않는 기능입니다");
    }

    public BizException(String message) {
        super(message);
    }
}
