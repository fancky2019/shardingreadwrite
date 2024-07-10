package com.fancky.shardingreadwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@SpringBootApplication

//使用core
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@MapperScan("com.fancky.shardingreadwrite.dao")
public class ShardingreadwriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingreadwriteApplication.class, args);
    }

}
