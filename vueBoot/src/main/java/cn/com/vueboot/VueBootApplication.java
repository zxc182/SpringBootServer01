package cn.com.vueboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.vueboot.system.dao")
public class VueBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueBootApplication.class, args);
	}

}
