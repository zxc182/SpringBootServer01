package com.vueboot.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vueboot.system.entity.SysUser;

@Mapper
public interface SysUserMapper {
	
	SysUser getAll();

	SysUser getByConditions(SysUser sysUser);
	

}
