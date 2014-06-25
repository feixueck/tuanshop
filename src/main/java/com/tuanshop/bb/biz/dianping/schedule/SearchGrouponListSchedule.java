package com.tuanshop.bb.biz.dianping.schedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuanshop.bb.biz.dianping.common.DianpingApiTool;
import com.tuanshop.bb.biz.dianping.dto.CategoryDTO;
import com.tuanshop.bb.biz.dianping.dto.TestDTO;
import com.tuanshop.bb.biz.dianping.dto.TuanDTO;

public class SearchGrouponListSchedule {
	
   public static void main(String [] ages){
		String apiUrl = "http://api.dianping.com/v1/deal/get_batch_deals_by_id";
		String appKey = "635875352";
		String secret = "397773086270492db98a3ee8242f931c";
       
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("deal_ids", "2-2308843");
		paramMap.put("format", "json");
		
		String requestResult = DianpingApiTool.requestApi(apiUrl, appKey,
				secret, paramMap);
		Map<String, Object> resultMap = (Map<String, Object>) JSON.parse(requestResult);
		System.out.println(resultMap);
		JSONArray array = (JSONArray) resultMap.get("deals");
		System.out.println(array);
		Iterator<Object> iterator = array.iterator();
		while(iterator.hasNext()){
			JSON json = (JSON) iterator.next();
			System.out.println(json);
			TestDTO tuan = JSON.toJavaObject(json, TestDTO.class);
			System.out.println(tuan.getTitle());
//		   System.out.println(tuan.getCity());
		}
		
   }

}
