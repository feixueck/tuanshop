package com.tuanshop.bb.dao.query;


import com.tuanshop.bb.dao.base.PageQuery;

public class AuthorityQuery<T> extends PageQuery<T> {
	
	public String getAuthorityname() {
		return authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}

	private String authorityname;

}
