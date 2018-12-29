package com.sr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sr.model.ResponeBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import com.sr.model.User;
import com.sr.service.UserService;

@RestController
public class UserController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${spring.datasource.url}")
    private String dburl;

    public String getDburl() {
        return dburl;
    }

    public void setDburl(String dburl) {
        this.dburl = dburl;
    }

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    @RequestMapping("/test")
    public String test() {
        logger.error("startwww", "执行中");
        return dburl;
    }


    @RequestMapping("/query")
    @ResponseBody
    @Transactional
    public void query(@RequestBody User reuser) {

//        User user = userService.queryList("abc","123");
            User user = userService.queryfirst(reuser.getUsername(), reuser.getPassword());
            System.out.println(user.getUsername());

            // ResponseJsonUtils.json(response, user);

            ResponeBody responeBody = new ResponeBody();
            responeBody.setCode(20);
            responeBody.setQueryId("123456");
            responeBody.setQueryId("55");
            responeBody.setMessage("开始");
            responeBody.setData(user);
            ResponseJsonUtils.json(response, responeBody);

    }

    @RequestMapping("/querySecond")
    public void querySecond() {
        User user = userService.secondQuery("we", "as");
        System.out.println(user.getUsername());
        ResponseJsonUtils.json(response, user);
    }
}
