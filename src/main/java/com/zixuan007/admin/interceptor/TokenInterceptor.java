package com.zixuan007.admin.interceptor;

import com.zixuan007.admin.common.utils.TokenUtil;
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
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            JSONObject json = new JSONObject();
            json.put("success", "false");
            json.put("msg", "认证失败");
            json.put("code", "500");

            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }


        return false;

    }


}
