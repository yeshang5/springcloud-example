package com.springcloud.bh.service.hystrix;

import com.springcloud.bh.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * 熔断器
 */
@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String sayHi(String message) {
        return String.format("你的消息是：%s ，但是请求连接失败！",message);
    }
}
