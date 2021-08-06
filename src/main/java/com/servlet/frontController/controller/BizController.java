package com.servlet.frontController.controller;

import com.exception.BizException;
import com.servlet.frontController.Controller;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class BizController implements Controller {

    private final String contentPath = "biz";

    public JSONObject process(String serviceName, JSONObject object){
        JSONObject result = new JSONObject();
        try {
            Class<?> aClass = Class.forName(contentPath + "." + serviceName);
            Method method = aClass.getMethod("execute", JSONObject.class);
            Object invoke = method.invoke(aClass.newInstance(), object);

            if ( invoke instanceof JSONObject ) {
                result = (JSONObject) invoke;
            }


        } catch (Throwable e) {
            throw new BizException("잘못된 요청입니다.");
        }
        return result;
    }
}
