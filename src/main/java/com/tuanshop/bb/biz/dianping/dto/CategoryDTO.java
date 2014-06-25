package com.tuanshop.bb.biz.dianping.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class CategoryDTO {
	@JSONField(name = "category_name")
	private String categoryName;
	@JSONField(name = "subcategories")
	private List<String> subcategories;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<String> subcategories) {
		this.subcategories = subcategories;
	}

}
