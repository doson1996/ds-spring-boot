package com.ds.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author ds
 * @Date 2020/8/31 13:08
 * @Version 1.0
 * @Description
 */

@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = {"com.ds.spring.boot.mapper"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
