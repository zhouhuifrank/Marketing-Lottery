# Marketing-Lottery
微服务营销项目服务-抽奖服务

## DDD架构分层
+ rpc层            提供rpc调用接口描述性文件，请求实体类
+ interfaces层     将application的接口暴露出去，供前端或者其他服务进行调用
+ application层    对项目中的领域服务进行流程的编排，事件的发布与订阅
+ domain层         提供项目的领域服务
+ infrastructure层 提供基础的数据服务，包括mysql，redis和ES等
+ common层         提供通用模块，包括统一返回对象，异常，常量，拦截器和工具类

## 项目使用技术
+ SpringBoot 2.x
+ MySql 8.x
+ Mybatis-Plus
+ Redis 6.x
+ Redisson
+ Dubbo 3.x
+ Zookeeper
+ Nacos
+ Kafka
+ XXL_Job
+ ELK
+ Canal
