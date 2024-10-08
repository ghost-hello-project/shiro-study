package com.laolang.jx.authorizingrealm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CustomAuthorizingRealmTest {

    @Test
    public void testCustomAuthorizingRealm() {
        String iniPath = "classpath:com/laolang/jx/authorizingrealm/shiro-custom-authorizing-realm.ini";
        // 1. 获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
        // 2. 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 3. 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            // 4. 登录
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5. 身份验证失败
            log.error("身份验证失败 :{}", ExceptionUtils.getMessage(e));
        }

        Assert.assertTrue(subject.isAuthenticated());

        // 6. 退出
        subject.logout();
    }
}
