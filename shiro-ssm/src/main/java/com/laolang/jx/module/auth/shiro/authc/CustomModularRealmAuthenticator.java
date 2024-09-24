package com.laolang.jx.module.auth.shiro.authc;

import cn.hutool.core.util.StrUtil;
import com.laolang.jx.module.auth.shiro.enums.PlatformType;
import com.laolang.jx.module.auth.shiro.token.ModularRealmToken;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

@Slf4j
public class CustomModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("CustomModularRealmAuthenticator.doAuthenticate execute");
        // 判断 getRealms 是否返回为空
        assertRealmsConfigured();

        // 强转为自定义的 Token
        ModularRealmToken token = (ModularRealmToken) authenticationToken;

        // 登录类型
        PlatformType platformType = token.getPlatformType();

        // 只处理 token 中的登录类型
        Collection<Realm> realms = getRealms();

        Collection<Realm> customRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if(StrUtil.equals(realm.getName(),platformType.getRealmName())){
                customRealms.add(realm);
            }
        }

        // 此处使用过滤后的 Realm 集合, 在此案例中, 就是走 doSingleRealmAuthentication
        if (customRealms.size() == 1) {
            log.info("doSingleRealmAuthentication execute");
            return doSingleRealmAuthentication(customRealms.iterator().next(), authenticationToken);
        } else {
            log.info("doMultiRealmAuthentication execute");
            return doMultiRealmAuthentication(customRealms, authenticationToken);
        }
    }

    @Override
    public void setRealms(Collection<Realm> realms) {
        super.setRealms(realms);
    }
}
