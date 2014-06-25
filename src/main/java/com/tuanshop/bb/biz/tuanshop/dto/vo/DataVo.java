package com.tuanshop.bb.biz.tuanshop.dto.vo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("data")
public class DataVo {
	@XStreamAlias("display")
	private DisplayVo display;
//	@XStreamImplicit(itemFieldName = "shops")
	@XStreamAlias("shops")
	private List<ShopVo> shopList;

	public DisplayVo getDisplay() {
		return display;
	}

	public void setDisplay(DisplayVo display) {
		this.display = display;
	}

	public List<ShopVo> getShopList() {
		return shopList;
	}

	public void setShopList(List<ShopVo> shopList) {
		this.shopList = shopList;
	}

}
