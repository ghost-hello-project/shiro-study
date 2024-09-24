package com.laolang.jx.module.admin.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminIndexController {

    @RequestMapping("/admin")
    public String index(Model model) {
        model.addAttribute("msg", "km 系统");
        return "admin/index";
    }

    @RequiresPermissions("admin:system:dict:typeList")
    @GetMapping("/admin/dict")
    public String dict(Model model) {
        model.addAttribute("msg", "km 系统");
        return "admin/dict";
    }

    @RequiresPermissions("seller:product:getInfo")
    @GetMapping("/admin/product")
    public String product(Model model) {
        model.addAttribute("msg", "km 系统");
        return "admin/product";
    }
}
