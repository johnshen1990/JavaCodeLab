package io.github.johnshen1990.javacodelab.javabasic.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;

/**
 * Author: zhun.shen
 * Date: 2016-09-04 00:18
 * Description:
 */
public class FirstInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("first pre");
        String handlerClassName = handler.getClass().getName();
        String handlerCanonicalName = handler.getClass().getCanonicalName();
        HandlerMethod handlerMethod = null;
        if(handler instanceof HandlerMethod){
            handlerMethod = (HandlerMethod)handler;
            String methodName = handlerMethod.getMethod().getName();
            System.out.println(methodName);
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("first post");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("first after");
        super.afterCompletion(request, response, handler, ex);
    }
}
