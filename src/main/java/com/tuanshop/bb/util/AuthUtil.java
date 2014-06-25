package com.tuanshop.bb.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AuthUtil {
	/**
	 * 判断用户是否有对应权限
	 * 
	 * @param auth
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean hasAuth(Long auth) throws UnsupportedEncodingException {
		boolean boo = false;

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Set<Long> authSet = (Set<Long>) session.getAttribute("auths");
		if (authSet.contains(auth)) {
			boo = true;
		}
		return boo;
	}

	/**
	 * 获取用户的权限集合
	 * 
	 * @return
	 */
	public static Set<Long> getUserAuths() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Set<Long> authSet = (Set<Long>) session.getAttribute("auths");
		return authSet;
	}

	public static boolean isLogin() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String) request.getSession().getAttribute("userId");
		if (StringUtils.isNotBlank(userId)) {
			return true;
		} else {
			return false;
		}
	}
}
