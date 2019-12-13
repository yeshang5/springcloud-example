 模块名称 | 端口号 | 备注 
 --- | --- | --- 
eureka-server|8761|服务注册与发现
eureka-client|8762/8763|服务提供者(启动多个实例实现高可用)
eureka-consumer-ribbon|8764|服务消费者-ribbon方式 (负载均衡)
eureka-consumer-feign|8765|服务消费者-feign方式 (feign默认集成了ribbon实现了负载均衡)

