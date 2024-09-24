package com.laolang.jx.module.auth.shiro.filter;

import cn.hutool.core.util.StrUtil;
import com.laolang.jx.module.auth.consts.AuthConst;
import com.laolang.jx.module.auth.util.AuthUtil;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class AuthFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (AuthUtil.matchAdminUrl(httpServletRequest)) {
            WebUtils.issueRedirect(request, response, AuthConst.ADMIN_LOGIN_URL);
        } else if (AuthUtil.matchPortalUrl(httpServletRequest)) {
            WebUtils.issueRedirect(request, response, AuthConst.PORTAL_LOGIN_URL);
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }
}
