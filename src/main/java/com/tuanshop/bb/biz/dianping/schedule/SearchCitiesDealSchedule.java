package com.tuanshop.bb.biz.dianping.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuanshop.bb.biz.dianping.common.DianpingApiTool;
import com.tuanshop.bb.biz.dianping.dto.CityDTO;
import com.tuanshop.bb.dao.CityInfoDao;
import com.tuanshop.bb.dao.impl.CityInfoDaoImpl;
import com.tuanshop.bb.pojo.dianping.CityDomain;
import com.tuanshop.bb.service.CityInfoService;
import com.tuanshop.bb.util.Globals;

/**
 * 获取支持团购搜索的最新城市列表
 * 
 * @author wangkaick
 * 
 */
public class SearchCitiesDealSchedule {

	public  List<String> addCity() {
		String apiUrl = "http://api.dianping.com/v1/metadata/get_cities_with_deals";
		String appKey = "635875352";
		String secret = "397773086270492db98a3ee8242f931c";
        
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("format", "json");

		String requestResult = DianpingApiTool.requestApi(apiUrl, appKey, secret, paramMap);
		System.out.println(requestResult);

		CityDTO citydto = JSON.parseObject(requestResult, CityDTO.class);

		if (citydto.getStatus().equals(Globals.SUCCESS)) {
			List<String> lists = citydto.getCityList();
			System.out.println("--------支持团购的城市如下:");
		
			for (String city : lists) {
				/**
				 * 在这里 ,dto转换成domain,然后存数据库
				 */
				System.out.println(city);
			}
			System.out.println(lists.size());
			 return lists;
		}else{
		    return null;
		}
	}

}
