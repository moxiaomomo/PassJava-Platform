package com.moxiaomomo.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@Controller
public class TestController {
    @GetMapping("/wstest")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("wstest");
        return mav;
    }
}
