package com.springcloud.bh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

   @Autowired
   private RestTemplate restTemplate;


   public String sayHi(String message)
   {
       return restTemplate.getForObject("http://eureka-client/hi?message="+message,String.class);
   }

}
