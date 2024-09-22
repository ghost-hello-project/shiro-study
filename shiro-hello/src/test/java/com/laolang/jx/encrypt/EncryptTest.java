package com.laolang.jx.encrypt;

import cn.hutool.core.collection.CollUtil;
import com.laolang.jx.encrypt.encrypt.EncryptUtil;
import java.util.HashSet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

@Slf4j
public class EncryptTest {

    @Test
    public void testEncrypt() {
        String salt = EncryptUtil.generateSalt();
        String input = "123";
        System.out.println(salt);
        System.out.println(input);
        System.out.println(EncryptUtil.sha1(input, salt));
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(EncryptUtil.sha1(input, salt));
        }
        HashSet<String> set = new HashSet<>(list);
        Assert.assertTrue(CollUtil.isNotEmpty(set));
        Assert.assertEquals(set.size(), 1);
    }

    @BeforeClass
    public void beforeClass() {
        // 1. 获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        String iniPath = "classpath:com/laolang/jx/encrypt/shiro-custom-authorizing-realm-with-encrypt.ini";
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
        // 2. 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

    }

    @Test
    public void testRealmWithEncrypt() {
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

    @Test(expectedExceptions = IncorrectCredentialsException.class)
    public void testRealmWithEncryptErrorPassword() {
        // 3. 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "xxx");

        // 4. 登录
        subject.login(token);
    }
}