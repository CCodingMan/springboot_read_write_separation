package com.ljj.springboot_read_write_separation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ljj.springboot_read_write_separation.mapper")
public class SpringbootReadWriteSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReadWriteSeparationApplication.class, args);
    }

}
