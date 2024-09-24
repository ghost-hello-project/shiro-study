package com.laolang.jx.module.auth.util;

import cn.hutool.core.util.StrUtil;
import com.laolang.jx.module.auth.consts.AuthConst;
import javax.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthUtil {

    public static boolean matchAdminUrl(HttpServletRequest request) {
        return StrUtil.startWith(request.getRequestURI(), AuthConst.ADMIN_URL_PREFIX);
    }

    public static boolean matchPortalUrl(HttpServletRequest request) {
        return StrUtil.startWith(request.getRequestURI(), AuthConst.PORTAL_URL_PREFIX);
    }

    public static String getForbiddenViewName(HttpServletRequest request) {
        if (matchAdminUrl(request)) {
            return AuthConst.ADMIN_FORBIDDEN_VIEW_NAME;
        } else if (matchPortalUrl(request)) {
            return AuthConst.PORTAL_FORBIDDEN_VIEW_NAME;
        }
        return getErrorViewName(request);
    }

    public static String getErrorViewName(HttpServletRequest request) {
        if (matchAdminUrl(request)) {
            return AuthConst.ADMIN_ERROR_VIEW_NAME;
        } else if (matchPortalUrl(request)) {
            return AuthConst.PORTAL_ERROR_VIEW_NAME;
        }
        return AuthConst.PORTAL_ERROR_VIEW_NAME;
    }
}
