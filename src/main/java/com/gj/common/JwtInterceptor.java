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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
//	@Autowired
//	private JwtService jwtService;
	private final String saltKey = "JinGyung";
	private Log log = LogFactory.getLog(JwtInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("accessToken")) {
				if (validateToken(cookies[i].getValue()).equals("Expiration")) {
				}
				if (validateToken(cookies[i].getValue()).equals("Modulation")) {
				}
			}

		}
		return super.preHandle(request, response, handler);
	}

	public String validateToken(String jwt) throws Exception {
		try {
			Claims claims = Jwts.parser().setSigningKey(saltKey.getBytes()).parseClaimsJws(jwt).getBody();
			return "true";
		} catch (ExpiredJwtException exception) {
			return "Expiration";
		} catch (JwtException exception) {
			return "Modulation";
		}

	}
}
