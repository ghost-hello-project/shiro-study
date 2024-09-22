package com.laolang.jx.authorizingrealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomAuthorizingRealm extends AuthorizingRealm {

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
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

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
