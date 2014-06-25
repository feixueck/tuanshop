package com.tuanshop.bb.biz.dianping.schedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuanshop.bb.biz.dianping.common.DianpingApiTool;
import com.tuanshop.bb.biz.dianping.dto.CategoryDTO;
import com.tuanshop.bb.pojo.dianping.SortDomain;
import com.tuanshop.bb.service.SortInfoService;


@Service
public class SearchCategoryListSchedule {
	@Autowired
	private SortInfoService sorinfoservice;

	public Map<String, String> getSortMap() {
		String apiUrl = "http://api.dianping.com/v1/metadata/get_categories_with_deals";
		String appKey = "635875352";
		String secret = "397773086270492db98a3ee8242f931c";

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("format", "json");

		String requestResult = DianpingApiTool.requestApi(apiUrl, appKey, secret, paramMap);
		System.out.println(requestResult);
		Map<String, Object> resultMap = (Map<String, Object>) JSON.parse(requestResult);

		JSONArray array = (JSONArray) resultMap.get("categories");
		Iterator<Object> ite = array.iterator();
		Map<String, String> sortMap = new HashMap<String, String>();
		while (ite.hasNext()) {
			JSON json = (JSON) ite.next();
			CategoryDTO cate = JSON.toJavaObject(json, CategoryDTO.class);
			SortDomain sortdomain = new SortDomain();
			List<String> subCategoryList = cate.getSubcategories();
			for (String subCate : subCategoryList) {
				sortdomain.setMaxName(cate.getCategoryName());
				sortdomain.setMainName(subCate);
				sorinfoservice.add(sortdomain);
			}
		}
		System.out.println(sortMap.entrySet());
		return sortMap;
	}
}
