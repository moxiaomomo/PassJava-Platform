package com.xbyy.game.controller;

import com.alibaba.fastjson.JSONObject;
import com.xbyy.game.service.SSWDWordService;
import com.xbyy.game.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@Controller
@Slf4j
public class TestController {
    @Autowired
    private SSWDWordService wdWordService;

    @GetMapping("/wstest")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("wstest");
        return mav;
    }

    @ResponseBody
    @GetMapping("/getword")
    public ResultBody queryWord() {
        ResultBody res =  wdWordService.queryNewWord("100");
        log.info(JSONObject.toJSONString(res));
        return res;
    }
}
