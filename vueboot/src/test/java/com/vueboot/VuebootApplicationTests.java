package com.vueboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vueboot.system.entity.SysUser;
import com.vueboot.system.mapper.SysUserMapper;

@SpringBootTest
class VuebootApplicationTests {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	void contextLoads() {
		SysUser su  = sysUserMapper.getByConditions(new SysUser("1122"));
		System.out.println(su);
	}

}
