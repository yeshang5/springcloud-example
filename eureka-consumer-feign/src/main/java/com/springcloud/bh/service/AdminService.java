package com.springcloud.bh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client") /*服务提供者的名字*/
public interface AdminService {

    @GetMapping("hi")
    public String sayHi(@RequestParam("message")String message);  //需使用@RequestParam，否则报405错误

}
