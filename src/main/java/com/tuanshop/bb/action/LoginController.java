package com.tuanshop.bb.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanshop.bb.enums.AuthorityValue;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;
import com.tuanshop.bb.service.RoleAuthorityService;
import com.tuanshop.bb.service.UserInfoService;
import com.tuanshop.bb.service.UserRoleInfoService;
import com.tuanshop.bb.util.CookieUtil;
import com.tuanshop.bb.util.ImageTool;

@Controller
public class LoginController {
	@Resource
	private UserInfoService userSerivice;
	@Resource
	private UserRoleInfoService userRoleInfoService;
	@Resource
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping("/")
	public String login() {
		return "/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {

		Enumeration<String> ma = request.getAttributeNames();
		if (ma.hasMoreElements()) {
			System.out.println(ma.nextElement());
		}
		
		  MessageDigest md = null;
		    try {

		         md = MessageDigest.getInstance("MD5");

		      } catch (NoSuchAlgorithmException e) {

		         e.printStackTrace();
		      }
		
		      byte[] pass = md.digest(password.getBytes());
		      
		   
		      String uspass = ByteConvertString(pass);
		String code = request.getParameter("code");

		UserInfoDomain user = userSerivice.findUserByNameAndPasswd(username,
				uspass);
		String num=request.getSession().getAttribute("randCode").toString();
		
		if(!num.equals(code)){

			request.setAttribute("msg", "验证码错误");
			return "/login";
		}
		if (null == user) {
			request.setAttribute("msg", "用户不存在或账号错误");
			return "/login";
		} else {
			// 用户信息存入session
			String userId = request.getSession().getId() + "." + username;
			try {

				/**
				 * 获取该用户的角色,和对应的权限 ,放入权限set
				 */
				Set<Long> authoritys = new HashSet<Long>();
				List<UserRoleInfoDomain> urList = userRoleInfoService.findUserRole(user.getId());
				for (UserRoleInfoDomain tmp : urList) {
					Long roleId = tmp.getRoleId();
					RoleAuthorityInfoDomain rai = new RoleAuthorityInfoDomain();
					rai.setRoleId(roleId);
					List<RoleAuthorityInfoDomain> raList = roleAuthorityService.getList(rai);
					for (RoleAuthorityInfoDomain auth : raList) {
						authoritys.add(auth.getAuthorityId());
					}
				}
				CookieUtil.addCookie("userId", userId, response);
				HttpSession session = request.getSession();
				session.setAttribute(userId, user);
				session.setAttribute("auths", authoritys);
				session.setAttribute("userId", userId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "redirect:/user/index";
		}
	}

	@RequestMapping("/makeRandCode")
	public void makeRandCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ImageTool.service(request, response);

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/login";

	}

	
	   /**

	    *把经过加密的byte数组转换为string

	    **/

	   private static String ByteConvertString(byte[] bResult){

	      StringBuffer sb = new StringBuffer();
	      for(int i=0;i<bResult.length;i++){
	         int val = ((int)bResult[i]) & 0xff;//和11111111相与
	         if(val < 16){
	            sb.append("0");
	         }
	         sb.append(Integer.toHexString(val));
	      }
	  return sb.toString();

	   }

	
}
