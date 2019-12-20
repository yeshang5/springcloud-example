package com.springcloud.bh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String sayHi(String message)
    {
        return String.format("你的消息是：%s  端口号：%s",message,port);
    }

}
