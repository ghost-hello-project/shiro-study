package com.laolang.jx.module.portal.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalPageController {

    @RequestMapping("/portal/error/404")
    public String error404() {
        return "portal/error/404";
    }

    @RequestMapping("/portal/error/403")
    public String error403() {
        return "portal/error/403";
    }
}
