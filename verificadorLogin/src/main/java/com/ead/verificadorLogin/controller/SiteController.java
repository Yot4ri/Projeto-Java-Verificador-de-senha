package com.ead.verificadorLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SiteController {
    
    @RequestMapping("/login")
    public String login(){
    return "index";
    }   
}
