package com.laolang.jx.module.portal.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PortalIndexController {

    @RequestMapping("/portal")
    public String index() {
        return "portal/index";
    }
}
