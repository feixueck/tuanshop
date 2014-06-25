package com.tuanshop.bb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuanshop.bb.dao.query.AuthorityQuery;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.enums.AuthorityValue;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.service.AuthorityInfoService;
import com.tuanshop.bb.service.RoleInfoService;
import com.tuanshop.bb.service.UserInfoService;
import com.tuanshop.bb.service.impl.UserInfoServiceImpl;

@Controller
@RequestMapping("/authority")
public class AuthorityInfoContorller {
	@Autowired
	private AuthorityInfoService authorityinfoservice;
	@AuthorityValue("13")
	@RequestMapping("/index")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap,
			String authorityname,
			@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

		modelMap.addAttribute("title", "权限列表");

		AuthorityQuery<AuthorityInfoDomain> authorityQuery = new AuthorityQuery<AuthorityInfoDomain>();
		authorityQuery.setPageSize(pageSize);
		authorityQuery.setPageIndex(pageNo);
		authorityQuery.setAuthorityname(authorityname);
	    authorityinfoservice.findAuthorityPageList(authorityQuery);
		List<AuthorityInfoDomain> authorityrList = authorityQuery.getDataList();
		modelMap.addAttribute("authorityrList", authorityrList);
		modelMap.addAttribute("pageNo", authorityQuery.getPageIndex());
		modelMap.addAttribute("pageSize", authorityQuery.getPageSize());
		modelMap.addAttribute("recordCount", authorityQuery.getTotalRecord());
		modelMap.addAttribute("curr", 3);
		modelMap.addAttribute("username", authorityname);

		System.out.println(authorityrList.size());
		return "authority/index";
	}
	@AuthorityValue("10")
	@RequestMapping("delete")
	public String delete(HttpServletRequest request ,HttpServletResponse rseponse ,Long id){
		authorityinfoservice.delete(id);
		return "redirect:/authority/index ";
	}
	@AuthorityValue("11")
	@RequestMapping("findauthId")
	public String findanthId(HttpServletRequest request,HttpServletResponse response,Long id){
		AuthorityInfoDomain authorityinfo=new AuthorityInfoDomain();
	 authorityinfo=authorityinfoservice.findById(id);
	   request.setAttribute("authorityinfo", authorityinfo);	
	 return "authority/update";
	}
	@AuthorityValue("11")
	@RequestMapping("update")
	public String update(HttpServletRequest request,
			HttpServletResponse response, final AuthorityInfoDomain authority) {
		// 1 表示成功 2 失败
		Integer flag = null;
		// 返回给页面的提示语
		StringBuffer msg = new StringBuffer();
		if (authority.getId() == null) {
			msg.append("未获取主键信息");
			flag = 2;
		} else if (StringUtils.isEmpty(authority.getDescription())
				|| StringUtils.isEmpty(authority.getName())) {
			msg.append("属性存在空值,请填写后更新");
			flag = 2;
		} else {
			authorityinfoservice.update(authority);
			msg.append("更新成功");
			flag = 1;
		}

		request.setAttribute("flag", flag);
		request.setAttribute("msg", msg);
		return "redirect:/authority/index";
	}
	@AuthorityValue("9")
	@RequestMapping("doAdd")
	public String doAdd(){
		return "authority/add";
	}
	@AuthorityValue("9")
	@RequestMapping("add")
	public String add(HttpServletRequest request, HttpServletResponse response,	final AuthorityInfoDomain authroty) {
	// 1 表示成功 2 失败
	Integer flag = null;
	// 返回给页面的提示语
	StringBuffer msg = new StringBuffer();
	if (StringUtils.isEmpty(authroty.getName())
			|| StringUtils.isEmpty(authroty.getDescription())) {
		msg.append("属性存在空值,请填写后提交");
		flag = 2;
	} else {
		authorityinfoservice.add(authroty);
		msg.append("添加成功");
		flag = 1;
	}
	request.setAttribute("flag", flag);
	request.setAttribute("msg", msg);

	return "redirect:/authority/index";
}

}