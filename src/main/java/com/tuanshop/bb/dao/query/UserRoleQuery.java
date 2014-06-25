package com.tuanshop.bb.dao.query;

import com.tuanshop.bb.dao.base.PageQuery;

public class UserRoleQuery<T> extends PageQuery<T> {
	
	private String name;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
