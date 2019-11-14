package com.vueboot.system.service;

import com.vueboot.system.entity.SysUser;

/**
 *
 */
public interface ISysUserService {

    /**
     * 查询所有
     * @return
     */
    SysUser getAll();

    /**
     * 根据用户名查找
     * @param sysUser
     * @return
     */
    SysUser getByConditions(SysUser sysUser);
}
