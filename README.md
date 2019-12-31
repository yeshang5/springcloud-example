 模块名称 | 端口号 | 备注 
 --- | --- | --- 
eureka-server|8760,8761|服务注册与发现 (启动多个实例，并相互注册到对方，实现高可用集群)
eureka-client|8762/8763|服务提供者(启动多个实例实现高可用)
eureka-consumer-ribbon|8764|服务消费者-ribbon方式 (负载均衡)，使用了Hystrix实现服务熔断，防止服务雪崩
eureka-consumer-feign|8765|服务消费者-feign方式 (默认集成了ribbon实现了负载均衡，并使用feign自带熔断器，实现服务熔断。)
config-server|8888|分布式配置中心服务端
config-client||分布式配置中心实例
zuul|8766|路由网关
zipkin-server|9411 |链路追踪服务端
springcloud-admin|8084|springboot-admin服务监控


建议启动顺序：
*   eureka-server  服务注册与发现
*   config-server  分布式配置中心服务端
*   zipkin-server  链路追踪服务端
*   springcloud-admin   springboot-admin服务监控
*   eureka-client      服务提供者
*   eureka-consumer-ribbon/eureka-consumer-feign    服务消费者
*   zuul        路由网关

eureka-consumer-feign 增加Hystrix熔断器仪表盘监控

@EnableEurekaClient 注解标注的是服务提供者  
@EnableDiscoveryClient  注解标注的是服务消费者

因为zipkin官方已经不推荐自行搭建server端，故直接下载官方server端的jar包，
下载地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/

通过以下命令启动服务，默认INFO级别可以不设置logging日志级别
```
java -jar zipkin-server-2.12.2-exec.jar --logging.level.zipkin2=INFO
```

服务启动后访问`http://localhost:9411`即可看到zipkin的监控页面

![](https://s2.ax1x.com/2019/12/30/lQeaZT.png)
