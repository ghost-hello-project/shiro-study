package com.laolang.jx.module.auth.consts;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthConst {
    public static final String ADMIN_URL_PREFIX = "/admin";
    public static final String ADMIN_LOGIN_URL = "/auth/admin/login";
    public static final String ADMIN_NOT_FOUND_VIEW_NAME = "admin/error/404";
    public static final String ADMIN_FORBIDDEN_VIEW_NAME = "admin/error/403";
    public static final String ADMIN_ERROR_VIEW_NAME = "admin/error/403";

    public static final String PORTAL_URL_PREFIX = "/portal";
    public static final String PORTAL_LOGIN_URL = "/auth/portal/login";
    public static final String PORTAL_NOT_FOUND_VIEW_NAME = "portal/error/404";
    public static final String PORTAL_FORBIDDEN_VIEW_NAME = "portal/error/403";
    public static final String PORTAL_ERROR_VIEW_NAME = "portal/error/error";
}
