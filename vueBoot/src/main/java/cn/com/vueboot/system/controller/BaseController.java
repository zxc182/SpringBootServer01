package cn.com.vueboot.system.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.vueboot.system.util.ResponseResult;

/**
 * 当前项目中所有控制器类的基类
 * @author zxc
 *
 */
public abstract class BaseController {
	
	protected static final int  SUCCESS = 200;
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e) {
		Integer state = 200;
		return new ResponseResult<>(state,e);
	}
	/*
	 * protected Integer getUidSession(HttpSession session) { return
	 * Integer.valueOf(session.getAttribute("uid").toString()); }
	 */
}
