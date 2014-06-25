package com.tuanshop.bb.biz.tuanshop.dto.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("shop")
public class ShopVo {
	/**
	 * 商家名称
	 */
	private String name;
	/**
	 * 商家电话
	 */
	private String tel;
	/**
	 * 商家地址
	 */
	private String addr;
	/**
	 * 商圈
	 */
	private String area;
	/**
	 * 商家营业时间
	 */
	private String openTime;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 交通信息
	 */
	private String trafficInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getTrafficInfo() {
		return trafficInfo;
	}

	public void setTrafficInfo(String trafficInfo) {
		this.trafficInfo = trafficInfo;
	}

}
