package com.servlet.frontController;

import org.json.JSONObject;


public interface Controller {
    JSONObject process(String serviceName, JSONObject params);
}
