package com.laolang.jx.encrypt;

import com.laolang.jx.encrypt.encrypt.EncryptInfo;
import com.laolang.jx.encrypt.encrypt.EncryptUtil;
import java.util.Objects;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomAuthorizingRealmWithEncrypt extends AuthorizingRealm {

    public CustomAuthorizingRealmWithEncrypt() {
        //指定密码匹配方式为sha1
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(EncryptUtil.SHA1);
        //指定密码迭代次数
        matcher.setHashIterations(EncryptUtil.ITERATIONS);
        //使用父类方法使匹配方式生效
        setCredentialsMatcher(matcher);
    }

    @Override
    public String getName() {
        return "customAuthorizingRealmWithEncrypt";
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 用户名
        String username = (String) token.getPrincipal();
        // 密码
        String password = new String((char[]) token.getCredentials());

        EncryptInfo encryptInfo = queryUserInfo(token);

        // 用户名错误
        if (Objects.isNull(encryptInfo)) {
            throw new UnknownAccountException();
        }

        // 这里就不需要了
        /* // 密码错误
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        } */

        // 如果身份验证成功, 则返回一个 AuthenticationInfo 的实现
        return new SimpleAuthenticationInfo(username, encryptInfo.getPassword(), ByteSource.Util.bytes(encryptInfo.getSalt()), getName());
    }

    /**
     * 模拟用户查询
     */
    private EncryptInfo queryUserInfo(AuthenticationToken token) {
        return EncryptInfo.builder()
                .salt("fb25c3d608a15157d9d9d1ad8a009e8a")
                .algorithmName(EncryptUtil.SHA1)
                .password("07668092e661f3c44125731c136af43ba5d28c4e")
                .build();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
