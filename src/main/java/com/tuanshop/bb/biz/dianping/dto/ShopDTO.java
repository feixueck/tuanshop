package com.tuanshop.bb.biz.dianping.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class ShopDTO {
	
	@JSONField(name = "id")
	private String id;
	@JSONField(name = "name")
	private String name;
	@JSONField(name = "city")
	private String city;
	@JSONField(name = "address")
	private String address;
	@JSONField(name = "latitude")
	private String latitude;
	@JSONField(name = "longitude")
	private String longitude;
	@JSONField(name = "url")
	private String url;
	@JSONField(name = "h5_url")
	private String h5_url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getH5_url() {
		return h5_url;
	}
	public void setH5_url(String h5_url) {
		this.h5_url = h5_url;
	}


}
