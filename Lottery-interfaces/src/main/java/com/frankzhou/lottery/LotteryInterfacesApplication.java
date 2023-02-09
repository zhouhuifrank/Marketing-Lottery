package com.frankzhou.lottery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class LotteryInterfacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryInterfacesApplication.class, args);
        System.out.println("=====================================");
        System.out.println("========Lottery-Core项目启动成功=======");
        System.out.println("=====================================");
    }

}
