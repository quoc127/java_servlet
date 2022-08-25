package com.laptrinhjavaweb.model;

public class RoleModel extends AbstractModel<RoleModel>{
	
	private int code;
	private Long name;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	
}
