package com.tuanshop.bb.biz.dianping.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class TestDTO {
	@JSONField(name = "title")
	private String title;
	private List<String> regions;
	private List<ShopDTO> businesses;
	private String sImageUrl;
	private List<String> categories;

	public String getsImageUrl() {
		return sImageUrl;
	}

	@JSONField(name = "s_image_url")
	public void setsImageUrl(String sImageUrl) {
		this.sImageUrl = sImageUrl;
	}

	public List<ShopDTO> getBusinesses() {
		return businesses;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public void setBusinesses(List<ShopDTO> businesses) {
		this.businesses = businesses;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
