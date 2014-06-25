package com.tuanshop.bb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static String default_path
	     ="/";
	private static int default_age =365*24*3600;
	
    /**
     *@Function: 添加cookie 可設置時間
     *@Author: zhangZhiPeng
     *@param name
     *@param value
     *@param response
     *@param age
     *@throws UnsupportedEncodingException  void
     *@Date: 2014-2-19
     *@Modifications:
     *@Modifier Name; Date; The Reason for Modifying
     *
     */
	public static void addCookie(String name,String value,
			HttpServletResponse response,int age) throws UnsupportedEncodingException{
		
		Cookie cookie = 
		    new Cookie(name,URLEncoder.encode(value,"utf-8"));
		cookie.setMaxAge(age);
		cookie.setPath(default_path);
		response.addCookie(cookie);
		
	}
	/**
	 *@Function: 添加cookie 默認時間
	 *@Author: zhangZhiPeng
	 *@param name
	 *@param value
	 *@param response
	 *@throws UnsupportedEncodingException  void
	 *@Date: 2014-2-19
	 *@Modifications:
	 *@Modifier Name; Date; The Reason for Modifying
	 *
	 */
	public static void addCookie(String name,String value,HttpServletResponse
			response) throws UnsupportedEncodingException{
		addCookie(name,value,response,default_age);
		
	}
	/**
	 *@Function: 展示所有cookie
	 *@Author: zhangZhiPeng
	 *@param name
	 *@param request
	 *@return
	 *@throws UnsupportedEncodingException  String
	 *@Date: 2014-2-19
	 *@Modifications:
	 *@Modifier Name; Date; The Reason for Modifying
	 *
	 */
	public static String findCookie(String name,HttpServletRequest request) 
	       throws UnsupportedEncodingException{
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals(name)){
					value = URLDecoder.decode(cookie.getValue(), "utf-8");
					
				}
			}
		}
		return value;
		
	}
	/**
	 *@Function: 刪除cookie
	 *@Author: zhangZhiPeng
	 *@param name
	 *@param response  void
	 *@Date: 2014-2-19
	 *@Modifications:
	 *@Modifier Name; Date; The Reason for Modifying
	 *
	 */
	public static void deleteCookie(String name,HttpServletResponse
			response){
		Cookie cookie = new Cookie(name,"");
		cookie.setMaxAge(0);
		cookie.setPath(default_path);
		response.addCookie(cookie);
		
	}
}
