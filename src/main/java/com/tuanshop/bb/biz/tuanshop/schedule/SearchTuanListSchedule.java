package com.tuanshop.bb.biz.tuanshop.schedule;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.tuanshop.bb.biz.tuanshop.common.LaShouApiTool;
import com.tuanshop.bb.biz.tuanshop.dto.LaShouTuans;
import com.tuanshop.bb.biz.tuanshop.dto.vo.ShopVo;
import com.tuanshop.bb.biz.tuanshop.dto.vo.TuanUrl;
import com.tuanshop.bb.util.XmlUtil;

public class SearchTuanListSchedule {
	private static final String TUANS_URL = "http://open.lashou.com/opendeals/lashou/%s.xml";

	public static void main(String[] args) {
		String daqing = String.format(TUANS_URL, "782");

		try {
			String returnRequest = LaShouApiTool.get(daqing);
			LaShouTuans ltuans = XmlUtil.xmltoBean(returnRequest, LaShouTuans.class);
			System.out.println(ltuans.getTuans().size());
			for (TuanUrl tmp : ltuans.getTuans()) {
				List<ShopVo> shopList=tmp.getData().getShopList();
				ShopVo shop=shopList.get(0);
				System.out.println(shop.getLatitude()+"--"+shop.getLongitude());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
