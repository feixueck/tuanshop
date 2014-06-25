package com.tuanshop.bb.biz.dianping.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;



public class TuanDTO {
	
	@JSONField(name = "deal_id")
	private String deal_id;
	@JSONField(name = "title")
	private String title;
	@JSONField(name = "description")
	private String description;
	@JSONField(name = "city")
	private String city;
	@JSONField(name = "list_price")
	private String list_price;
	@JSONField(name = "current_price")
	private String current_price;
	@JSONField(name = "regions")
	private List<String> regions;
	@JSONField(name = "categories")
	private List<String> categories;
	@JSONField(name = "purchase_count")
	private String purchase_count;
	@JSONField(name = "purchase_deadline")
	private String purchase_deadline;
	@JSONField(name = "publish_date")
	private String publish_date;
	@JSONField(name = "details")
	private String details;
	@JSONField(name = "image_url")
	private String image_url;
	@JSONField(name = "s_image_url")
	private String s_image_url;
	@JSONField(name = "more_image_urls")
	private List<String> more_image_urls;
	@JSONField(name = "more_s_image_urls")
	private List<String> more_s_image_urls;
	@JSONField(name = "is_popular")
	private String is_popular;
	@JSONField(name = "restrictions")
	private List<String> restrictions;
	@JSONField(name = "notice")
	private String notice;
	@JSONField(name = "deal_url")
	private String deal_url;
	@JSONField(name = "deal_h5_url")
	private String deal_h5_url;
	@JSONField(name = "commission_ratio")
	private String commission_ratio;
	@JSONField(name = "businesses")
	private List<ShopDTO> businesses;
	public String getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getList_price() {
		return list_price;
	}
	public void setList_price(String list_price) {
		this.list_price = list_price;
	}
	public String getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(String current_price) {
		this.current_price = current_price;
	}
	public List<String> getRegions() {
		return regions;
	}
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getPurchase_count() {
		return purchase_count;
	}
	public void setPurchase_count(String purchase_count) {
		this.purchase_count = purchase_count;
	}
	public String getPurchase_deadline() {
		return purchase_deadline;
	}
	public void setPurchase_deadline(String purchase_deadline) {
		this.purchase_deadline = purchase_deadline;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getS_image_url() {
		return s_image_url;
	}
	public void setS_image_url(String s_image_url) {
		this.s_image_url = s_image_url;
	}
	public List<String> getMore_image_urls() {
		return more_image_urls;
	}
	public void setMore_image_urls(List<String> more_image_urls) {
		this.more_image_urls = more_image_urls;
	}
	public List<String> getMore_s_image_urls() {
		return more_s_image_urls;
	}
	public void setMore_s_image_urls(List<String> more_s_image_urls) {
		this.more_s_image_urls = more_s_image_urls;
	}
	public String getIs_popular() {
		return is_popular;
	}
	public void setIs_popular(String is_popular) {
		this.is_popular = is_popular;
	}
	public List<String> getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(List<String> restrictions) {
		this.restrictions = restrictions;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDeal_url() {
		return deal_url;
	}
	public void setDeal_url(String deal_url) {
		this.deal_url = deal_url;
	}
	public String getDeal_h5_url() {
		return deal_h5_url;
	}
	public void setDeal_h5_url(String deal_h5_url) {
		this.deal_h5_url = deal_h5_url;
	}
	public String getCommission_ratio() {
		return commission_ratio;
	}
	public void setCommission_ratio(String commission_ratio) {
		this.commission_ratio = commission_ratio;
	}
	public List<ShopDTO> getBusinesses() {
		return businesses;
	}
	public void setBusinesses(List<ShopDTO> businesses) {
		this.businesses = businesses;
	}

}
