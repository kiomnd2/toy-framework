package com.servlet.frontController;

import com.exception.BizException;
import com.servlet.frontController.controller.BizController;
import org.json.JSONObject;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

@WebServlet(name = "frontController", urlPatterns = "/front-controller/*")
public class FrontController extends HttpServlet {

    private HashMap<String, Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        controllerMap.put("/front-controller/biz", new BizController());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new BizException("지원하지 않는 기능입니다");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        if (!req.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            throw new BizException("지원하지 않는 기능입니다");
        }

        String requestURI = req.getRequestURI();

        JSONObject object = getJsonObject(req);

        String serviceName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        String servicePath = requestURI.substring(0, requestURI.lastIndexOf("/"));

        Controller controller = controllerMap.get(servicePath);

        if (controller == null || !serviceName.endsWith(".biz")) {
            throw new BizException("잘못된 요청입니다");
        }

        JSONObject result = controller.process(serviceName.substring(0, serviceName.lastIndexOf(".biz")), object);


        res.getWriter().write(result.toString());
    }

    private JSONObject getJsonObject(HttpServletRequest req) throws IOException {
        ServletInputStream inputStream = req.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return new JSONObject(sb.toString());
    }
}
