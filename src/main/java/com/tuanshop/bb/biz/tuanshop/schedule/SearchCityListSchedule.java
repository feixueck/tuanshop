package com.tuanshop.bb.biz.tuanshop.schedule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;

import com.tuanshop.bb.biz.tuanshop.common.LaShouApiTool;
import com.tuanshop.bb.biz.tuanshop.dto.LaShouCityDTO;
import com.tuanshop.bb.biz.tuanshop.dto.vo.BaseUrl;
import com.tuanshop.bb.util.XmlUtil;

public class SearchCityListSchedule {
	public static final String CITY_URL = "http://open.lashou.com/opendeals/lashou/city.xml";

	public static void main(String[] args) {
		try {
			// String resultRequest = LaShouApiTool.get(CITY_URL);
			/**
			 * 由于城市不经常更新,数据源暂时从本地xml文件读取
			 */
			InputStream inputStream = SearchCityListSchedule.class.getResourceAsStream("/biztuan/lashou-city.xml");
			String resultXml = IOUtils.toString(inputStream);
			LaShouCityDTO citydto = XmlUtil.xmltoBean(resultXml, LaShouCityDTO.class);
			List<BaseUrl> cityUrlList = citydto.getUrlList();
			BaseUrl url = new BaseUrl();
			for (BaseUrl tmp : cityUrlList) {
				/**
				 * baseUrl--->urldomain 转换成domain
				 */
				System.out.println(tmp.getCityId() + "--" + tmp.getCityName());
				tmp.getCityId();
				tmp.getCityName();
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
