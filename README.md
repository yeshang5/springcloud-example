 模块名称 | 端口号 | 备注 
 --- | --- | --- 
eureka-server|8761|服务注册与发现
eureka-client|8762/8763|服务提供者(启动多个实例实现高可用)
eureka-consumer-ribbon|8764|服务消费者-ribbon方式 (负载均衡)，使用了Hystrix实现服务熔断，防止服务雪崩
eureka-consumer-feign|8765|服务消费者-feign方式 (默认集成了ribbon实现了负载均衡，并使用feign自带熔断器，实现服务熔断。)

eureka-consumer-feign 增加Hystrix熔断器仪表盘监控

@EnableEurekaClient 注解标注的是服务提供者  
@EnableDiscoveryClient  注解标注的是服务消费者