package com.tuanshop.bb.action;

import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.enums.AuthorityValue;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;
import com.tuanshop.bb.service.RoleInfoService;
import com.tuanshop.bb.service.UserInfoService;
import com.tuanshop.bb.service.UserRoleInfoService;

/**
 * 管理用户controller
 * 
 * @author zuoshuai
 * 
 */
@Controller
@RequestMapping("/user")
public class UserAdminController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RoleInfoService roleinfoservice;
	@Autowired
	private UserRoleInfoService userroleinfoservice;
	
	@AuthorityValue("5")
	@RequestMapping("/index")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap,
			String username,
			@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

		modelMap.addAttribute("title", "用户列表");

		UserQuery<UserInfoDomain> userQuery = new UserQuery<UserInfoDomain>();
		userQuery.setPageSize(pageSize);
		userQuery.setPageIndex(pageNo);
		userQuery.setUsername(username);
		userInfoService.queryUserInfoPageList(userQuery);
		List<UserInfoDomain> userList = userQuery.getDataList();
		modelMap.addAttribute("userList", userList);
		modelMap.addAttribute("pageNo", userQuery.getPageIndex());
		modelMap.addAttribute("pageSize", userQuery.getPageSize());
		modelMap.addAttribute("recordCount", userQuery.getTotalRecord());
		modelMap.addAttribute("curr", 1);
		modelMap.addAttribute("username", username);

		System.out.println(userList.size());
		return "user/index";
	}
	@AuthorityValue("2")
	@RequestMapping(value = "/add")
	public String add() {
		return "user/add";
	}
	@AuthorityValue("2")
	@RequestMapping(value = "/doAdd")
	public String doAdd(HttpServletRequest request,
			HttpServletResponse response, final UserInfoDomain userinfo) {
		// 1 表示成功 2 失败
		Integer flag = null;
		// 返回给页面的提示语
		StringBuffer msg = new StringBuffer();
		if (StringUtils.isEmpty(userinfo.getUsername())
				|| StringUtils.isEmpty(userinfo.getUserpwd())) {
			msg.append("属性存在空值,请填写后提交");
			flag = 2;
		} else {
			  MessageDigest md = null;
			    try {

			         md = MessageDigest.getInstance("MD5");

			      } catch (NoSuchAlgorithmException e) {

			         e.printStackTrace();
			      }
			      byte[] pass = md.digest(userinfo.getUserpwd().getBytes());
			      //

			      String uspass = ByteConvertString(pass);
			      
			      userinfo.setUsername(userinfo.getUsername());
			      userinfo.setUserpwd(uspass);
			userInfoService.add(userinfo);
			msg.append("添加成功");
			flag = 1;
		}
		request.setAttribute("flag", flag);
		request.setAttribute("msg", msg);

		return "user/add";
	}
	@AuthorityValue("3")
	@RequestMapping(value = "/update")
	public String update(HttpServletRequest request,
			HttpServletResponse response, Long userId) {
		UserInfoDomain user = userInfoService.findId(userId);
		request.setAttribute("user", user);
		return "user/update";
	}
	@AuthorityValue("3")
	@RequestMapping(value = "/doUpdate")
	public String update(HttpServletRequest request,
			HttpServletResponse response, final UserInfoDomain userinfo) {
		// 1 表示成功 2 失败
		Integer flag = null;
		// 返回给页面的提示语
		StringBuffer msg = new StringBuffer();
		if (userinfo.getId() == null) {
			msg.append("未获取主键信息");
			flag = 2;
		} else if (StringUtils.isEmpty(userinfo.getUsername())
				|| StringUtils.isEmpty(userinfo.getUserpwd())) {
			msg.append("属性存在空值,请填写后更新");
			flag = 2;
		} else {
			userInfoService.update(userinfo);
			msg.append("更新成功");
			flag = 1;
		}
		
		request.setAttribute("flag", flag);
		request.setAttribute("msg", msg);
		return "user/update";
	}
	@AuthorityValue("4")
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response, Long userId){
		System.out.println(userId);
		userInfoService.delete(userId);
		 return "redirect:/user/index "; 
		
	}
	
	
	
	@RequestMapping("/findbyuserid")
	public String findByRoleId(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,Long userId) {
		 
          UserInfoDomain userinfodomain=new UserInfoDomain();
          userinfodomain=userInfoService.findId(userId);
          request.setAttribute("user", userinfodomain);
          System.out.println(userinfodomain.getUsername());
		
		List<UserRoleInfoDomain> userrolequery = new ArrayList<UserRoleInfoDomain>();
		userrolequery= userroleinfoservice.findUserRole(userId);
		RoleInfoDomain role=new RoleInfoDomain();
		List<RoleInfoDomain>roleList=new ArrayList<RoleInfoDomain>();
		for(int i=0;i<userrolequery.size();i++){	
		role=roleinfoservice.findById(userrolequery.get(i).getRoleId());
		roleList.add(role);
		} 
		request.setAttribute("roleLists", roleList);
		return "userrole/addrole";
	}
	
	@AuthorityValue("14")
	@RequestMapping("config")
	public String config(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, Long userId) {
		System.out.println(request.getAttribute("msg"));
		//根据Id获得当前用户
		UserInfoDomain user = userInfoService.findId(userId);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		// 获取所有的角色
		RoleQuery<RoleInfoDomain> query = new RoleQuery<RoleInfoDomain>();
		query.setPageSize(200);
		roleinfoservice.queryRoleInfoPageList(query);
		List<RoleInfoDomain> roleList = query.getDataList();
		// 获取当前角用户所有角色
		UserRoleInfoDomain userrole = new UserRoleInfoDomain();
		userrole.setUserId(userId);
		List<Long> alist=new ArrayList<Long>();
		//根据用户ID查询当前用户拥有的角色
		List<UserRoleInfoDomain> raList = userroleinfoservice.findUserRole(userId);
		for (UserRoleInfoDomain tmp : raList) {
			alist.add(tmp.getRoleId());
		}
		modelMap.put("alist", alist);//角色ID    user_role 表的 roleid  
		modelMap.put("roleList", roleList);//角色集合   authList
		modelMap.put("user", user);//user对象   role
		return "user/config";
	}	
	
	@RequestMapping("addUserRole")
	public String configAuth(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, Long userId,
			String auths) {
		StringBuffer msg = new StringBuffer();
		// 判断角色是否获取
		if (null == userId) {
			msg.append("未获取角色主键");
		} else {
			// 删除就得角色配置
			userroleinfoservice.dltUserRole(userId);
			// 插入新的角色
			if (StringUtils.isNotEmpty(auths)) {
				String[] authArr = auths.split(",");

				for (String auth : authArr) {
					UserRoleInfoDomain userrole = new UserRoleInfoDomain();
					userrole.setUserId(userId);
					userrole.setRoleId(Long.valueOf(auth));
					userroleinfoservice.add(userrole);
				}
			}
			msg.append("权限配置成功");
		}
		request.setAttribute("msg", msg);
		return "forward:config";
	}
	
	private static String ByteConvertString(byte[] bResult) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < bResult.length; i++) {

			int val = ((int) bResult[i]) & 0xff;// 和11111111相与

			if (val < 16) {

				sb.append("0");

			}

			sb.append(Integer.toHexString(val));

		}
		return sb.toString();

	}
	
}
