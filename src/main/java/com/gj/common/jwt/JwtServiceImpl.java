package com.gj.common.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {
	private Log log = LogFactory.getLog(JwtServiceImpl.class);

	private final String saltKey = "themembers";

	@Override
	public String createToken(HttpServletRequest res) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "HS256");

		Map<String, Object> payloads = new HashMap<>();
		Long expiredTime = 1000 * 60l;
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);

		String user = res.getParameter("user");
		String name = res.getParameter("name");
		// Test Codes
		user = "testuser";
		name = "test";
		// -------
		payloads.put("user", user);
		payloads.put("name", name);

		String jwt = Jwts.builder().setHeader(headers).setClaims(payloads).setExpiration(now)
				.signWith(SignatureAlgorithm.HS256, saltKey.getBytes()).compact();

		return jwt;
	}

	@Override
	public boolean validateToken(String jwt) throws Exception {
		try {
			Claims claims = Jwts.parser().setSigningKey(saltKey.getBytes()).parseClaimsJws(jwt).getBody();

			log.info("expireTime : " + claims.getExpiration());
			log.info("user : " + claims.get("user"));
			log.info("name : " + claims.get("name"));
			return true;
		} catch (ExpiredJwtException exception) {
			log.info("Token Expiration");
			return false;
		} catch (JwtException exception) {
			log.info("Token Modulation");
			return false;
		}

	}

}
