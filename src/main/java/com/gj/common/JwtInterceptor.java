package com.gj.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

	private final String SALT_KEY = "JinGyung";
	private Log log = LogFactory.getLog(JwtInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String result = "Null";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
			if (cookies[i].getName().equals("accessToken")) {
				result = "Effective";
				if (validateToken(cookies[i].getValue()).equals("Expiration")) {
					result = "Expiration";
				}
				if (validateToken(cookies[i].getValue()).equals("Modulation")) {
					result = "Modulation";
				}
			}
		}
		System.out.println("Token Validation Result :" + result);
		if (!result.equals("Effective")) {
			if (result.equals("Null")) {
				response.sendError(400, "Token Modulation");
			} else if (result.equals("Expiration")) {
				response.sendError(401, "Token Expiration");
			} else if (result.equals("Modulation")) {
				response.sendError(400, "Token Modulation");
			}
		}

		return super.preHandle(request, response, handler);
	}

	public String validateToken(String jwt) throws Exception {
		String result = "";
		try {
			Claims claims = Jwts.parser().setSigningKey(SALT_KEY.getBytes()).parseClaimsJws(jwt).getBody();
			result = "true";
		} catch (ExpiredJwtException exception) {
			result = "Expiration";
		} catch (JwtException exception) {
			result = "Modulation";
		}
		// System.out.println(result);
		return result;
	}
}
