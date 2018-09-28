package com.sie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.sie.mapper")
public class TestonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestonlineApplication.class, args);
    }
}
