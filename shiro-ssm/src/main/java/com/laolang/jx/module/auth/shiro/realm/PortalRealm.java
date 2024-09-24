package com.laolang.jx.module.auth.shiro.realm;

import com.laolang.jx.module.auth.shiro.enums.PlatformType;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class PortalRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return PlatformType.PortalRealm.getRealmName();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("{} getAuthenticationInfo execute", getName());

        // 用户名
        String username = (String) token.getPrincipal();
        // 密码
        String password = new String((char[]) token.getCredentials());

        // 用户名错误
        if (!"portal".equals(username)) {
            throw new UnknownAccountException();
        }

        // 密码错误
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }

        // 如果身份验证成功, 则返回一个 AuthenticationInfo 的实现
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


}
