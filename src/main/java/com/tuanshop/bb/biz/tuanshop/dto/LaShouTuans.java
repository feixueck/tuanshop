package com.tuanshop.bb.biz.tuanshop.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.tuanshop.bb.biz.tuanshop.dto.vo.TuanUrl;

@XStreamAlias("urlset")
public class LaShouTuans {
	@XStreamImplicit(itemFieldName = "url")
	private List<TuanUrl> tuans;

	public List<TuanUrl> getTuans() {
		return tuans;
	}

	public void setTuans(List<TuanUrl> tuans) {
		this.tuans = tuans;
	}

}
