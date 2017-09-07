package io.github.johnshen1990.javawebapp.interceptor;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView modelAndView = null;
        if(ex != null) {
            System.out.println("Log into error!");
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
}
