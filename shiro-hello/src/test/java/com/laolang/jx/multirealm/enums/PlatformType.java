package com.laolang.jx.multirealm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Realm 类型
 */
@Getter
@AllArgsConstructor
public enum PlatformType {

    MyRealm("myRealm", "简单 Realm"),
    MyAuthorizingRealm("myAuthorizingRealm", "带认证和授权的 Realm");

    private final String realmName;
    private final String desc;
}
