package com.tuanshop.bb.biz.tuanshop.dto;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.tuanshop.bb.biz.tuanshop.dto.vo.BaseUrl;

@XStreamAlias("urlset")
public class LaShouCityDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 隐式集合
	 */
	@XStreamImplicit(itemFieldName = "url")
	private List<BaseUrl> urlList;

	public List<BaseUrl> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<BaseUrl> urlList) {
		this.urlList = urlList;
	}

}
