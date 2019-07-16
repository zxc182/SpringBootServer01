package com.initspringboot.vueboot.controller;

import javax.servlet.http.HttpSession;

import com.initspringboot.vueboot.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 所有控制器父类
 *
 */
public class BaseController {
	//正确响应时的的代码
	public static final Integer SUCCESS = 200;

	@ExceptionHandler({RuntimeException.class})
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e){
		
		Integer state = 200;
		if(e instanceof RuntimeException) {
			state = 300;
		}
		/*StatusReportingFilter srf = new StatusReportingFilter();
		int st = srf.status;*/
		return new ResponseResult<>(state,e);


	}
	
	protected Integer getUidSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
}
