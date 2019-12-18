package com.springcloud.bh.service;

import com.springcloud.bh.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  @FeignClient 注解中value为服务提供者的名字,fallback为服务熔断类
 */
@FeignClient(value = "eureka-client",fallback = AdminServiceHystrix.class)
public interface AdminService {

    @GetMapping("hi")

    public String sayHi(@RequestParam("message")String message);  //需使用@RequestParam，否则报405错误

}
