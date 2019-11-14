package com.vueboot.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Controller 注解 在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
  *   若返回json等内容到页面，则需要加@ResponseBody注解
  *   
  * @RestController =  @Controller + @ResponseBody
 */
@RestController
public class TestController {
	
	
	@RequestMapping("/test")
	public String get() {
		return "到了";
	}

}
