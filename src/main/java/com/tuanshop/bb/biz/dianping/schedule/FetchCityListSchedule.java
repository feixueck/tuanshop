package com.tuanshop.bb.biz.dianping.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuanshop.bb.biz.dianping.common.DianpingApiTool;
import com.tuanshop.bb.biz.dianping.dto.CitiesList;
import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;
import com.tuanshop.bb.service.GroupInfoService;

/**
 * 
 * 获取城市list
 * 
 * @author wangkaick
 * 
 */
@Service
public class FetchCityListSchedule {

	   @Autowired
	   private GroupInfoService groupinfoservice;
	   
	public  void getGroup() {

		String apiUrl = "http://api.dianping.com/v1/deal/get_all_id_list";
		String appKey = "635875352";
		String secret = "397773086270492db98a3ee8242f931c";

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("city", "北京");
		paramMap.put("category", "美食");
		paramMap.put("format", "json");

		String requestResult = DianpingApiTool.requestApi(apiUrl, appKey,
				secret, paramMap);
		Map<String, Object> retMap = (Map<String, Object>) JSON
				.parse(requestResult);
		System.out.println(retMap.get("status"));
		System.out.println(retMap.get("id_list"));
		JSONArray jsonstr = (JSONArray) (retMap.get("id_list"));
		List<String> ids = new ArrayList<String>();
		jsonstr.addAll(ids);
		Iterator<Object> iterator = jsonstr.iterator();
		GroupInfoDomain groupinfodomain=new GroupInfoDomain();
		while (iterator.hasNext()) {
		//	String tuanid=iterator.next().toString();
			groupinfodomain.setTuanId(iterator.next().toString());
			groupinfoservice.add(groupinfodomain);
			System.out.println(iterator.next());
		}
	//	List<String> list = (List<String>) retMap.get("id_list");

	//	System.out.println(retMap.get("count"));
		// CitiesList city = new CitiesList();
		// city.setCount("1111");
		// city.setStatus("ok");
		// List<String> cityids = new ArrayList<String>();
		// cityids.add("11011");
		// cityids.add("11011");
		// cityids.add("11011");
		// cityids.add("11011");
		// city.setId_list(cityids);
		//
		// String json = JSON.toJSONString(city);
		// System.out.println(json);

	}
}
