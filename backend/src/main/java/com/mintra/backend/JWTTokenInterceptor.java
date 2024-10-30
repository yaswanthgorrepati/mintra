package com.mintra.backend;

import com.mintra.backend.util.JWTTokenGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static com.mintra.backend.json.error.MessageDescriptions.JWT_HEADER_TOKEN;

@Component
public class JWTTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwtToken = request.getHeader(JWT_HEADER_TOKEN);
        boolean isTokenValid = jwtTokenGenerator.validateJWT(jwtToken);
        System.out.println("isTokenValid :" + isTokenValid);
        return isTokenValid;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in posthandle");
    }
}
