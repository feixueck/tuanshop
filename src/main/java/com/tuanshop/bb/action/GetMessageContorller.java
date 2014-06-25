package com.tuanshop.bb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanshop.bb.biz.dianping.schedule.FetchCityListSchedule;
import com.tuanshop.bb.biz.dianping.schedule.SearchCategoryListSchedule;
import com.tuanshop.bb.biz.dianping.schedule.SearchCitiesDealSchedule;
import com.tuanshop.bb.pojo.dianping.CityDomain;
import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;

import com.tuanshop.bb.service.CityInfoService;
import com.tuanshop.bb.service.GrouponInfoService;
import com.tuanshop.bb.service.SortInfoService;

@Controller
@RequestMapping("/getmessage")
public class GetMessageContorller {
	@Autowired
	private CityInfoService cityinfoservice;
	@Autowired
	private SortInfoService sorinfoservice;
	@Autowired
	private SearchCategoryListSchedule categorySchedule;
	@Autowired
	private FetchCityListSchedule fetchCityListSchedule;
	@Autowired
	private GrouponInfoService groupominfoservice;

	@RequestMapping("/index")
	public String testMap(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("menu", 2);
		request.setAttribute("curr", 4);
		return "tuans/map";
	}

	// @RequestMapping("/getcity")
	public String getCity(HttpServletRequest request, HttpServletResponse response) {
		SearchCitiesDealSchedule scd = new SearchCitiesDealSchedule();
		List<String> list = new ArrayList<String>();
		CityDomain cd = new CityDomain();
		list = scd.addCity();
		for (String city : list) {
			System.out.println(city);
			cd.setName(city);
			cd.setDescription("城市名称");
			cityinfoservice.add(cd);
		}
		System.out.println("ok");

		return "ok";

	}

	// @RequestMapping("/getcity")
	public String getSort(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> sortMap = new HashMap<String, String>();
		sortMap = categorySchedule.getSortMap();
		return "ok";
	}

	@RequestMapping("/getcity")
	public String getGroup(HttpServletRequest request, HttpServletResponse response) {
		fetchCityListSchedule.getGroup();
		return "ok";
	}
	//@RequestMapping("/getcity")
	public String getGroupon(HttpServletRequest request, HttpServletResponse response) {
		GrouponInfoDomain sd=new GrouponInfoDomain();
    	for(int i=0;i<20 ;i++){
       sd.setCityName("张三");
       sd.setSource("张三");
       sd.setTitle("张三");
       sd.setDescribe("张三");
       sd.setImgUrl("张三");
       sd.setMaxType("张三");
       sd.setMainTipe("张三");
      // sd.setStartTime(startTime);
     //  sd.setOverTime(overTime);
       sd.setPurchaseCount("张三");
       sd.setPrice("张三");
       sd.setCurrentPrice("张三");
       sd.setCriteria("张三");
       sd.setNotice("张三");
       sd.setDetail("张三");
       sd.setBsName("张三");
       sd.setPhon("张三");
       sd.setBsAddress("张三");
       sd.setLongitude("张三");
       sd.setLatitude("张三");
       sd.setTrafficInfo("张三");
       System.out.println(sd);
		groupominfoservice.add(sd);
	
    	}
    	return "ok";
	}
}
