package com.tuanshop.bb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.service.UserInfoService;

/**
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/logins")
public class UserRegisterController {
	@Autowired
	private UserInfoService userInfoDao;
	
	/**
	 * 访问: http://localhost:8080/tuan-bb/login/register?name=taikang&pwd=123&
	 * address=kaifeng
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param pwd
	 * @param address
	 * @return
	 */
	@RequestMapping("/register")
	public String register(HttpServletRequest request, HttpServletResponse response, String name, String pwd, String address) {
	
		System.out.println("enter");
		UserInfoDomain user = new UserInfoDomain();
		user.setUsername(name);
		user.setUserpwd(pwd);
		user.setAddress(address);
		

		Long userId = userInfoDao.add(user);
		System.out.println(userId);
	  
		//request.setAttribute("name", "zuojuntao");
		return "tuanshop/ok";
	}

// There is no statement named getTotalCount in this SqlMap.
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, String name, String pwd, String address) {

		return "tuanshop/index";
	}


	@RequestMapping("/findId")
	public String fingId(HttpServletRequest request, HttpServletResponse response ,Long id){
		System.out.println(id+"sdf1111111111111111111111111111111");  
		UserInfoDomain user = new UserInfoDomain();
		user=userInfoDao.findId(id);
		  
		System.out.print(user.getAddress()+"1111111111111111111111111111");
		//request.setAttribute("user", user);
		return "tuanshop/ok";
	}

}
