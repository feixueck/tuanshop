package com.tuanshop.bb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tuanshop.bb.enums.AuthorityValue;
import com.tuanshop.bb.util.AuthUtil;

public class AuthorityInteceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----拦截器执行了--------" + request.getRequestURI());
		String uri = request.getRequestURI();
		/**
		 * 图片,js等资源请求放过
		 */
		if (uri.indexOf(".") != -1) {
			return true;
		}
		/**
		 * 验证码请求和首页请求放过
		 */
		if (uri.equals("/") || uri.equals("/makeRandCode") || uri.equals("/doLogin")||uri.equals("/logout")||uri.equals("/getmessage/getcity")) {
			return true;
		}
		/**
		 * 如果没有登录,返回登录页
		 */
		if (!AuthUtil.isLogin()) {
			response.sendRedirect("/");
			return false;
		}
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthorityValue authValue = ((HandlerMethod) handler).getMethodAnnotation(AuthorityValue.class);
			String method_authvalue = authValue.value();
			if (AuthUtil.getUserAuths().contains(Long.valueOf(method_authvalue))) {
				return super.preHandle(request, response, handler);
			} else {
				response.sendRedirect("/");
				return false;
			}

		}
		return true;

	}

}
