package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.RoleAuth;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CustomerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String role = request.getHeader("role");
        if (StringUtils.isEmpty(role)) {
            Map<String, String> map = new HashMap<>();
            map.put("code", "401");
            map.put("msg", "Not login");
            String s = JSONObject.toJSONString(map);
            response.getOutputStream().write(s.getBytes("UTF8"));
            return false;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RoleAuth annotation = handlerMethod.getMethod().getAnnotation(RoleAuth.class);
        if (annotation != null && annotation.value().length > 0) {
            boolean accessible = false;
            for (String s : annotation.value()) {
                if (role.equalsIgnoreCase(s)) {
                    accessible = true;
                    break;
                }
            }

            if (!accessible) {
                Map<String, String> map = new HashMap<>();
                map.put("code", "403");
                map.put("msg", "Access Denied");
                String s = JSONObject.toJSONString(map);
                response.getOutputStream().write(s.getBytes("UTF8"));
                return false;
            }
        }

        return true;
    }
}
