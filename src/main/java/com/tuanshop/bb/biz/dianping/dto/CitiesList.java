package com.tuanshop.bb.biz.dianping.dto;

import java.util.List;

public class CitiesList {

	private String status;
	private String count;
	private List<String> id_list;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getId_list() {
		return id_list;
	}

	public void setId_list(List<String> id_list) {
		this.id_list = id_list;
	}

}
