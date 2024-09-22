package com.laolang.jx.multirealm.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

@Slf4j
public class MyRealm implements Realm {

    @Override
    public String getName() {
        return "myRealm";
    }

    /**
     * 仅支持  UsernamePasswordToken
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("{} getAuthenticationInfo execute", getName());
        // 用户名
        String username = (String) token.getPrincipal();
        // 密码
        String password = new String((char[]) token.getCredentials());

        // 用户名错误
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }

        // 密码错误
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }

        // 如果身份验证成功, 则返回一个 AuthenticationInfo 的实现
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
