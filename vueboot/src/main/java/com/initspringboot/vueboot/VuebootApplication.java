package com.initspringboot.vueboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.initspringboot.vueboot.dao")
public class VuebootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuebootApplication.class, args);
    }

}
