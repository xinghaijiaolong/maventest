package com.sr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;


@Controller
public class TestController {
    protected static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

}
