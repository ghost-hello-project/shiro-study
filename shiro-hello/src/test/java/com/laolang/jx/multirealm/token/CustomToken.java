package com.laolang.jx.multirealm.token;

import com.laolang.jx.multirealm.enums.PlatformType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.UsernamePasswordToken;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomToken extends UsernamePasswordToken {

    private PlatformType platformType;

    public CustomToken(String username, String password, PlatformType platformType) {
        super(username, password);
        this.platformType = platformType;
    }
}
