package com.laolang.jx.module.auth.shiro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Realm 类型
 */
@Getter
@AllArgsConstructor
public enum PlatformType {

    AdminRealm("adminRealm", "管理台"),
    PortalRealm("portalRealm", "前台");

    private final String realmName;
    private final String desc;
}
