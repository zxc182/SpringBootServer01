package com.vueboot.system.entity;

import java.sql.Timestamp;

public class SysUser {
	//用户id
	private String sysId;
	//用户名
	private String sysUsername;
	//密码
	private String sysPassword;
	//盐
	private String sysSalt;
	//头像
	private String sysAvatar;
	//创建人id
	private String sysCreateUser;
	//创建时间
	private Timestamp sysCreateTime;
	//修改人id
	private String sysUpdateUser;
	//修改时间
	private Timestamp sysUpdateTime;
	
	
	public String getSysId() {
		return sysId;
	}
	
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	
	public String getSysUsername() {
		return sysUsername;
	}
	
	public void setSysUsername(String sysUsername) {
		this.sysUsername = sysUsername;
	}
	
	public String getSysPassword() {
		return sysPassword;
	}
	
	public void setSysPassword(String sysPassword) {
		this.sysPassword = sysPassword;
	}
	
	public String getSysSalt() {
		return sysSalt;
	}
	
	public void setSysSalt(String sysSalt) {
		this.sysSalt = sysSalt;
	}
	
	public String getSysAvatar() {
		return sysAvatar;
	}
	
	public void setSysAvatar(String sysAvatar) {
		this.sysAvatar = sysAvatar;
	}
	public String getSysCreateUser() {
		return sysCreateUser;
	}
	
	public void setSysCreateUser(String sysCreateUser) {
		this.sysCreateUser = sysCreateUser;
	}
	
	public Timestamp getSysCreateTime() {
		return sysCreateTime;
	}
	public void setSysCreateTime(Timestamp sysCreateTime) {
		this.sysCreateTime = sysCreateTime;
	}
	
	public String getSysUpdateUser() {
		return sysUpdateUser;
	}
	
	public void setSysUpdateUser(String sysUpdateUser) {
		this.sysUpdateUser = sysUpdateUser;
	}
	
	public Timestamp getSysUpdateTime() {
		return sysUpdateTime;
	}
	
	public void setSysUpdateTime(Timestamp sysUpdateTime) {
		this.sysUpdateTime = sysUpdateTime;
	}
	
	@Override
	public String toString() {
		return "SysUser [sysId=" + sysId + ", sysUsername=" + sysUsername + ", sysPassword=" + sysPassword
				+ ", sysSalt=" + sysSalt + ", sysAvatar=" + sysAvatar + ", sysCreateUser=" + sysCreateUser
				+ ", sysCreateTime=" + sysCreateTime + ", sysUpdateUser=" + sysUpdateUser + ", sysUpdateTime="
				+ sysUpdateTime + "]";
	}
	
	public SysUser(String sysId, String sysUsername, String sysPassword, String sysSalt, String sysAvatar,
			String sysCreateUser, Timestamp sysCreateTime, String sysUpdateUser, Timestamp sysUpdateTime) {
		super();
		this.sysId = sysId;
		this.sysUsername = sysUsername;
		this.sysPassword = sysPassword;
		this.sysSalt = sysSalt;
		this.sysAvatar = sysAvatar;
		this.sysCreateUser = sysCreateUser;
		this.sysCreateTime = sysCreateTime;
		this.sysUpdateUser = sysUpdateUser;
		this.sysUpdateTime = sysUpdateTime;
	}






}
