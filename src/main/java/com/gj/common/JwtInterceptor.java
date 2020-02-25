package com.gj.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gj.common.jwt.JwtService;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private JwtService jwtService;
	
	private Log log = LogFactory.getLog(JwtInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("accessToken")) {
				// 토큰 만료
				if (jwtService.validateToken(cookies[i].getValue()).equals("Expiration")) {
				}
				// 토큰 변조
				if (jwtService.validateToken(cookies[i].getValue()).equals("Modulation")) {
						
				}
			}

		}
		return super.preHandle(request, response, handler);
	}
}
