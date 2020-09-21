package com.zixuan007.admin.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.Result;
import com.zixuan007.admin.pojo.ResultStatus;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author apple
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final String TOKEN_NAME = "small-admin-token";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");

        String token = request.getHeader("small-admin-token");
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
                System.out.println("检测到token信息: " + token);
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
           /* JSONObject json = new JSONObject();
            json.put("success", "false");
            json.put("msg", "认证失败");
            json.put("code", "500");
           */
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(Result.failure(ResultStatus.UNAUTHORIZED));
            response.getWriter().append(objectMapper.writeValueAsString(Result.failure(ResultStatus.UNAUTHORIZED)));
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }


        return false;

    }


}
