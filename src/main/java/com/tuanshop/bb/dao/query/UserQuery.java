package com.tuanshop.bb.dao.query;

import com.tuanshop.bb.dao.base.PageQuery;

public class UserQuery<T> extends PageQuery<T> {
	private String username;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
