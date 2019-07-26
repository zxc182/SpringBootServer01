package com.initspringboot.vueboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.initspringboot.vueboot.dao")
@EnableSwagger2
public class VuebootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuebootApplication.class, args);
    }

}
