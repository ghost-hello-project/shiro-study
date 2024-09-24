package com.laolang.jx.module.auth.controller;

import com.laolang.jx.module.auth.shiro.enums.PlatformType;
import com.laolang.jx.module.auth.shiro.token.ModularRealmToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/auth")
@Controller
public class AuthController {

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    @PostMapping("/admin/loginForm")
    public String adminLogin(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new ModularRealmToken(username, password, PlatformType.AdminRealm);
        subject.login(token);
        log.info("admin login");
        return "redirect:/admin";
    }

    @RequestMapping("/admin/error/403")
    public String adminError403() {
        return "admin/error/403";
    }

    @GetMapping("/portal/login")
    public String portalLoginPage() {
        return "portal/login";
    }

    @PostMapping("/portal/loginForm")
    public String portalLogin(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new ModularRealmToken(username, password, PlatformType.PortalRealm);
        subject.login(token);
        log.info("portal login");
        return "redirect:/portal";
    }

    @RequestMapping("/portal/error/403")
    public String portalError403() {
        return "portal/error/403";
    }

    //@ResponseBody
    //@GetMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //public R<UserinfoRsp> userinfo() {
    //    return R.ok(adminAuthLogic.userinfo());
    //}
}
