package com.hitsme.sshdemo.controller;

import com.hitsme.sshdemo.redis.RedisCacheUtil;
import com.hitsme.sshdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mgl
 */
@Controller
public class TestController {

    @Autowired(required = true)
    private UserService userService;
    @Resource
    private RedisCacheUtil redisCacheUtil;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser() {
        userService.saveUser();
        return "success!";
    }

    @RequestMapping(value = "testredis", method = RequestMethod.GET)
    @ResponseBody
    public String testRedis() {
        //第一种方式

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/config/spring/applicationContext-redis.xml");
       // context.start();
        //redisCacheUtil = (RedisCacheUtil)context.getBean("redisCache");
    redisCacheUtil.set("hello","world");
     return redisCacheUtil.get("hello").toString();
    }
}
