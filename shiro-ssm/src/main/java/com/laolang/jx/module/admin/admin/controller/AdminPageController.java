package com.laolang.jx.module.admin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

    @RequestMapping("/admin/error/404")
    public String error404() {
        return "admin/error/404";
    }

    @RequestMapping("/admin/error/403")
    public String error403() {
        return "admin/error/403";
    }
}
