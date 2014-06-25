package com.tuanshop.bb.dao.query;

import com.tuanshop.bb.dao.base.PageQuery;

public class RoleQuery<T> extends PageQuery<T>{


	private String rolename;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
