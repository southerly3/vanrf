package com.vanrf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.vanrf.mapper")
@SpringBootApplication
public class VanrfblogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VanrfblogsApplication.class, args);
    }

}
