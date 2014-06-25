package com.tuanshop.bb.biz.dianping.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class CityDTO {
	@JSONField(name = "status")
	private String status;
	@JSONField(name = "cities")
	private List<String> cityList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

}
