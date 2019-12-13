package com.springcloud.bh.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

   @Autowired
   private RestTemplate restTemplate;


   @HystrixCommand(fallbackMethod ="hiError" )
   public String sayHi(String message)
   {
       return restTemplate.getForObject("http://eureka-client/hi?message="+message,String.class);
   }

   public String hiError(String message)
   {
      return String.format("你的消息是：%s ，但是请求连接失败！",message);
   }

}
