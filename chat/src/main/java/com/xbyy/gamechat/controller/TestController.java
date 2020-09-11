package com.xbyy.gamechat.controller;

import com.xbyy.gamechat.service.WordService;
import com.xbyy.gamechat.utils.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@Controller
public class TestController {
    @Autowired
    private WordService wordService;

    @GetMapping("/wstest")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("wstest");
        return mav;
    }

    @ResponseBody
    @GetMapping("/getword")
    public ResultBody queryWord() {
        return wordService.queryNewWord("100");
    }
}
