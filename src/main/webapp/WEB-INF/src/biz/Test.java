package biz;

import com.servlet.annotation.BizService;
import org.json.JSONObject;


@BizService(name = "test")
public class Test {


    public JSONObject execute(JSONObject params) {

        params.put("test", "test1111");
        params.put("test2", "test1112");
        params.put("test3", "test1113");

        return params;
    }
}
