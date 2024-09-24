package com.laolang.jx.module.portal.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalPageController {

    @GetMapping("/portal/manager")
    public String manager() {
        return "portal/manager/index";
    }

    @GetMapping("/portal/error/404")
    public String error404(){
        return "portal/error/404";
    }
}
