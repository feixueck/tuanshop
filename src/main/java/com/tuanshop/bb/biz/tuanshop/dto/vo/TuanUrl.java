package com.tuanshop.bb.biz.tuanshop.dto.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TuanUrl {
	@XStreamAlias("loc")
	private String loc;
	@XStreamAlias("wapLoc")
	private String wapLoc;
	@XStreamAlias("data")
	private DataVo data;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getWapLoc() {
		return wapLoc;
	}

	public void setWapLoc(String wapLoc) {
		this.wapLoc = wapLoc;
	}

	public DataVo getData() {
		return data;
	}

	public void setData(DataVo data) {
		this.data = data;
	}

}
