package cn.com.vueboot.system.controller;

import cn.com.vueboot.system.emtity.User;
import cn.com.vueboot.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.vueboot.system.util.ResponseResult;

@RestController
@RequestMapping("/user")
@Api(tags="用户系统-用户管理")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@PostMapping("/findUser")
	@ApiOperation(value="查询用户数据", notes = "查询用户数据")
	public ResponseResult<User> findUser(
			@RequestBody User user
	){
		System.out.println(user.toString());

		return new ResponseResult<>(SUCCESS,userService.findUser(user));
	}

}
