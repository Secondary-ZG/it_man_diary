package com.secondary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Java Class
 * Created By Secondary
 * On 2019/11/5 15:00
 * Description: 登录控制类
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

}
