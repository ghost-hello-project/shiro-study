package com.laolang.jx.module.auth.shiro.token;

import com.laolang.jx.module.auth.shiro.enums.PlatformType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.UsernamePasswordToken;

@EqualsAndHashCode(callSuper = true)
@Data
public class ModularRealmToken extends UsernamePasswordToken {

    private final PlatformType platformType;

    public ModularRealmToken(String username, String password, PlatformType platformType) {
        super(username, password);
        this.platformType = platformType;
    }
}
