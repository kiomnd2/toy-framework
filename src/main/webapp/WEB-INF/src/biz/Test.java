package biz;

import com.servlet.model.BizProcessor;
import org.json.JSONObject;

public class Test implements BizProcessor {

    @Override
    public JSONObject execute(JSONObject params) {

        params.put("test", "test1111");
        params.put("test2", "test1112");
        params.put("test3", "test1113");

        return params;
    }
}
