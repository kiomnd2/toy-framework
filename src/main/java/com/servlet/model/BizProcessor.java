package com.servlet.model;

import org.json.JSONObject;

public interface BizProcessor {

    JSONObject execute(JSONObject params);

}
