package com.example.checkcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xianpeng.xia
 * on 2019-06-23 09:18
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/index")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/index");
        mv.addObject("title", "欢迎!");
        return mv;
    }
}
