# Marketing-Lottery
微服务营销项目服务-抽奖服务

## DDD架构分层
+ rpc层            提供rpc调用接口描述性文件，请求实体类
+ interfaces层     将application的接口暴露出去，供前端或者其他服务进行调用
+ application层    对项目中的领域服务进行流程的编排，事件的发布与订阅，定时任务调度
+ domain层         提供项目的领域服务
+ infrastructure层 提供基础的数据服务，包括mysql和ES等,实现domain层的repository接口
+ redis层          提供redis缓存的操作 一般给domain层使用，放在infrastructure会出现循环依赖，因此单独新增一个子模块
+ common层         提供通用模块，包括统一返回对象，异常，常量，拦截器和工具类

## 项目使用技术
+ SpringBoot 2.7.8
+ Mysql 8.0.31
+ Redis 6.6
+ Dubbo 3.0.7
+ Redisson
+ Mybatis-Plus
+ Zookeeper 
+ Kafka
+ XXL_Job
+ Nacos
+ ELK (ElasticSearch、Kibana)
+ canal
