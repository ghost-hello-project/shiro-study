package com.laolang.jx.persist.service.impl;

import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.persist.entity.SysUser;
import com.laolang.jx.persist.mapper.SysUserMapper;
import com.laolang.jx.persist.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper sysUserMapper;
}
