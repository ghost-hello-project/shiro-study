package com.laolang.jx.module.admin.auth.controller;

import com.laolang.jx.framework.common.consts.MediaType;
import com.laolang.jx.framework.common.core.R;
import com.laolang.jx.module.admin.auth.logic.AdminAuthLogic;
import com.laolang.jx.module.admin.auth.rsp.UserinfoRsp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin/auth")
@RequiredArgsConstructor
@Controller
public class AdminAuthController {

    private final AdminAuthLogic adminAuthLogic;

    @ResponseBody
    @GetMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R<UserinfoRsp> userinfo() {
        return R.ok(adminAuthLogic.userinfo());
    }
}
