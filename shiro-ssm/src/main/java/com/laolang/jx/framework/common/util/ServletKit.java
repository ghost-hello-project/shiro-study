package com.laolang.jx.framework.common.util;

import cn.hutool.core.util.StrUtil;
import javax.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServletKit {

    /**
     * 是否是Ajax异步请求
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.contains("application/json")) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.contains("XMLHttpRequest")) {
            return true;
        }

        String uri = request.getRequestURI();
        if (StrUtil.equalsAnyIgnoreCase(uri, ".json", ".xml")) {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        return StrUtil.equalsAnyIgnoreCase(ajax, "json", "xml");
    }
}
