package com.tuanshop.bb.biz.tuanshop.dto.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class BaseUrl {
	@XStreamAlias("city_name")
	private String cityName;
	@XStreamAlias("city_id")
	private String cityId;
	@XStreamAlias("city_deals_url")
	private String cityUrl;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityUrl() {
		return cityUrl;
	}

	public void setCityUrl(String cityUrl) {
		this.cityUrl = cityUrl;
	}

}
