package com.laolang.jx.framework.web.handler;

import com.laolang.jx.module.auth.util.AuthUtil;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("portal/index");
        return mv;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNotFoundException(NoHandlerFoundException e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("portal/index");
        return mv;
    }

    @ExceptionHandler(ShiroException.class)
    public ModelAndView shiroExceptionHandler(ShiroException e, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof UnauthorizedException) {
            mv.setViewName(AuthUtil.getForbiddenViewName(request));
        } else {
            mv.setViewName(AuthUtil.getErrorViewName(request));
        }
        return mv;
    }
}
