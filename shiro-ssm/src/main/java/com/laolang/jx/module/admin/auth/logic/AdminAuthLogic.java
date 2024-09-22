package com.laolang.jx.module.admin.auth.logic;

import com.laolang.jx.module.admin.auth.rsp.UserinfoRsp;
import com.laolang.jx.persist.entity.SysUser;
import com.laolang.jx.persist.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminAuthLogic {

    private final SysUserService sysUserService;

    public UserinfoRsp userinfo() {
        UserinfoRsp rsp = new UserinfoRsp();

        SysUser sysUser = sysUserService.getById(1L);
        BeanUtils.copyProperties(sysUser, rsp);
        return rsp;
    }
}
