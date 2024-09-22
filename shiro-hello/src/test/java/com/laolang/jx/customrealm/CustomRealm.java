package com.laolang.jx.customrealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * 自定义 Realm
 */
public class CustomRealm implements Realm {

    @Override
    public String getName() {
        return "customRealm";
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