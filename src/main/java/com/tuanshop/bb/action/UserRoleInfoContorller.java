package com.tuanshop.bb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;
import com.tuanshop.bb.service.UserRoleInfoService;

@Controller
@RequestMapping("userrole")
public class UserRoleInfoContorller {
	@Autowired
	private UserRoleInfoService userroleservice;
	@RequestMapping("findUserRole")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap,
			Long id,
			@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		modelMap.addAttribute("title", "用户列表");
		UserRoleQuery<UserRoleInfoDomain> userroleQuery = new UserRoleQuery<UserRoleInfoDomain>();
		userroleQuery.setPageSize(pageSize);
		userroleQuery.setPageIndex(pageNo);
		userroleQuery.setId(id);
		userroleservice.findUserRolePageList(userroleQuery);
		List<UserRoleInfoDomain> userroleList = userroleQuery.getDataList();
		modelMap.addAttribute("userroleList", userroleList);
		modelMap.addAttribute("pageNo", userroleQuery.getPageIndex());
		modelMap.addAttribute("pageSize", userroleQuery.getPageSize());
		modelMap.addAttribute("recordCount", userroleQuery.getTotalRecord());
		modelMap.addAttribute("curr", 1);
		modelMap.addAttribute("id", id);
         
		System.out.println(userroleList.size());
		return "userrole/user_role_list";
	}
	
	

}
