package com.tuanshop.bb.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuanshop.bb.dao.query.AuthorityQuery;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.enums.AuthorityValue;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.service.AuthorityInfoService;
import com.tuanshop.bb.service.RoleAuthorityService;
import com.tuanshop.bb.service.RoleInfoService;

@Controller
@RequestMapping("/role")
public class RoleInfoContorller {
	@Autowired
	private RoleInfoService roleinfoservice;
	@Autowired
	private AuthorityInfoService authorityinfoservice;
	@Autowired
	private RoleAuthorityService roleAuthorityService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param roleinfo
	 * @return
	 */
	@RequestMapping("/ss")
	public String ss() {
		System.out.println("hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return "user/index";
	}
	@AuthorityValue("8")
	@RequestMapping("/noadd")
	public String noadd() {
		return "role/add";
	}
	@AuthorityValue("8")
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response,
			final RoleInfoDomain roleinfo) {
		// 1 表示成功 2 失败
		Integer flag = null;
		// 返回给页面的提示语
		StringBuffer msg = new StringBuffer();
		if (StringUtils.isEmpty(roleinfo.getName())
				|| StringUtils.isEmpty(roleinfo.getDescription())) {
			msg.append("属性存在空值,请填写后提交");
			flag = 2;
		} else {
			roleinfoservice.add(roleinfo);
			msg.append("添加成功");
			flag = 1;
		}
		request.setAttribute("flag", flag);
		request.setAttribute("msg", msg);

		return "role/add";
	}
	@AuthorityValue("6")
	@RequestMapping("/delete")
	public String dltRole(HttpServletRequest request,
			HttpServletResponse rosponse, Long id) {
		roleinfoservice.delete(id);
		return "redirect:/role/rolelist ";
	}
	@AuthorityValue("7")
	@RequestMapping("/update")
	public String update(HttpServletRequest request,
			HttpServletResponse response, final RoleInfoDomain roleinfo) {
		// 1 表示成功 2 失败
		Integer flag = null;
		// 返回给页面的提示语
		StringBuffer msg = new StringBuffer();
		if (roleinfo.getId() == null) {
			msg.append("未获取主键信息");
			flag = 2;
		} else if (StringUtils.isEmpty(roleinfo.getDescription())
				|| StringUtils.isEmpty(roleinfo.getName())) {
			msg.append("属性存在空值,请填写后更新");
			flag = 2;
		} else {
			roleinfoservice.update(roleinfo);
			msg.append("更新成功");
			flag = 1;
		}

		request.setAttribute("flag", flag);
		request.setAttribute("msg", msg);
		return "role/update";
	}
	@AuthorityValue("7")
	@RequestMapping("/findbyid")
	public String findById(HttpServletRequest request,
			HttpServletResponse respons, Long id) {
		RoleInfoDomain roleinfodomain = new RoleInfoDomain();
		roleinfodomain = roleinfoservice.findById(id);
		request.setAttribute("role", roleinfodomain);
		return "role/update";
	}

	@RequestMapping("/findbyname")
	public String findByName(HttpServletRequest request,
			HttpServletResponse respons, String name) {
		RoleInfoDomain roleinfodomain = new RoleInfoDomain();
		roleinfodomain = roleinfoservice.findByName(name);
		return "user/index";
	}
	@AuthorityValue("5")
	@RequestMapping("/rolelist")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap,
			String rolename,
			@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

		modelMap.addAttribute("title", "角色列表");
		System.out.println(rolename + "1111111111111");
		RoleQuery<RoleInfoDomain> roleQuery = new RoleQuery<RoleInfoDomain>();
		roleQuery.setPageSize(pageSize);
		roleQuery.setPageIndex(pageNo);
		roleQuery.setRolename(rolename);
		roleinfoservice.queryRoleInfoPageList(roleQuery);
		List<RoleInfoDomain> queryList = roleQuery.getDataList();
		modelMap.addAttribute("roleList", queryList);
		modelMap.addAttribute("pageNo", roleQuery.getPageIndex());
		modelMap.addAttribute("pageSize", roleQuery.getPageSize());
		modelMap.addAttribute("recordCount", roleQuery.getTotalRecord());
		modelMap.addAttribute("curr", 2);
		modelMap.addAttribute("rolename", rolename);

		System.out.println(queryList.size());
		return "role/index";
	}
	@AuthorityValue("15")
	@RequestMapping("/config")
	public String config(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, Long roleId) {
		System.out.println(request.getAttribute("msg"));
		RoleInfoDomain role = roleinfoservice.findById(roleId);
		List<Long> alist=new ArrayList<Long>();
		// 获取所有的权限
		AuthorityQuery<AuthorityInfoDomain> query = new AuthorityQuery<AuthorityInfoDomain>();
		query.setPageSize(200);
		authorityinfoservice.findAuthorityPageList(query);
		List<AuthorityInfoDomain> authList = query.getDataList();
		// 获取当前角色的所有权限
		RoleAuthorityInfoDomain radomain = new RoleAuthorityInfoDomain();
		radomain.setRoleId(roleId);
		List<RoleAuthorityInfoDomain> raList = roleAuthorityService
				.getList(radomain);
		for (RoleAuthorityInfoDomain tmp : raList) {
			alist.add(tmp.getAuthorityId());
		}
		
		modelMap.put("authList", authList);
		modelMap.put("role", role);
		modelMap.put("alist", alist);

		return "role/config";
	}
	@AuthorityValue("15")
	@RequestMapping("/config-auth")
	public String configAuth(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, Long roleId,
			String auths) {
		StringBuffer msg = new StringBuffer();
		// 判断角色是否获取
		if (null == roleId) {
			msg.append("未获取角色主键");
		} else {
			// 删除就得角色配置
			roleAuthorityService.deleteByRole(roleId);
			// 插入新的角色
			if (StringUtils.isNotEmpty(auths)) {
				String[] authArr = auths.split(",");

				for (String auth : authArr) {
					RoleAuthorityInfoDomain radomain = new RoleAuthorityInfoDomain();
					radomain.setRoleId(roleId);
					radomain.setAuthorityId(Long.parseLong(auth));
					roleAuthorityService.add(radomain);
				}
			}
			msg.append("权限配置成功");
		}
		request.setAttribute("msg", msg);
		return "forward:config";
	}
}
