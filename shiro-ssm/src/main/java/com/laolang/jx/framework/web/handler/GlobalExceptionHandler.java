package com.laolang.jx.framework.web.handler;

import com.laolang.jx.framework.common.core.R;
import com.laolang.jx.framework.common.util.ServletKit;
import com.laolang.jx.module.auth.util.AuthUtil;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("portal/index");
        return mv;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNotFoundException(NoHandlerFoundException e, HttpServletRequest request) {
        ModelAndView mv;
        if (ServletKit.isAjaxRequest(request)) {
            mv = new ModelAndView(new MappingJackson2JsonView());
            R<?> r = R.notFound();
            r.fillModelAndView(mv);
        } else {
            mv = new ModelAndView();
            mv.setViewName(AuthUtil.getForbiddenViewName(request));
        }
        return mv;
    }

    @ExceptionHandler(ShiroException.class)
    public ModelAndView shiroExceptionHandler(ShiroException e, HttpServletRequest request) {
        ModelAndView mv;
        if (ServletKit.isAjaxRequest(request)) {
            mv = new ModelAndView(new MappingJackson2JsonView());
            if (e instanceof UnauthorizedException) {
                R<?> r = R.unauthorized();
                r.fillModelAndView(mv);
            } else {
                R<?> r = R.failed(ExceptionUtils.getMessage(e));
                r.fillModelAndView(mv);
                mv.setViewName(AuthUtil.getErrorViewName(request));
            }

        } else {
            mv = new ModelAndView();
            if (e instanceof UnauthorizedException) {
                mv.setViewName(AuthUtil.getForbiddenViewName(request));
            } else {
                mv.setViewName(AuthUtil.getErrorViewName(request));
            }
        }

        return mv;
    }
}
