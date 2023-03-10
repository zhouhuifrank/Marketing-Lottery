package com.frankzhou.lottery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.frankzhou"})
@EnableDubbo
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableScheduling
@MapperScan(basePackages = "com.frankzhou.infrastructure.mapper")
public class LotteryInterfacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryInterfacesApplication.class, args);
        System.out.println("=====================================");
        System.out.println("========Lottery-Core项目启动成功=======");
        System.out.println("=====================================");
    }

}
