package com.gj.common.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.gj.common.dto.MemberDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {
	private Log log = LogFactory.getLog(JwtServiceImpl.class);

	private final String saltKey = "JinGyung";

	@Override
	public String createToken(MemberDTO member) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "HS256");

		Map<String, Object> payloads = new HashMap<>();
		Long expiredTime = 60l * 15l * 1000l;
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);

		payloads.put("memId", member.getMemId());
		payloads.put("type", member.getMemType());

		String jwt = Jwts.builder().setHeader(headers).setClaims(payloads).setExpiration(now)
				.signWith(SignatureAlgorithm.HS256, saltKey.getBytes()).compact();

		return jwt;
	}

	@Override
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

	@Override
	public String refreshToken() {
		Long expiredTime = 60l * 60l * 24l * 7l * 1000l;
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "HS256");

		Map<String, Object> payloads = new HashMap<>();
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);

		String jwt = Jwts.builder().setHeader(headers).setClaims(payloads).setExpiration(now)
				.signWith(SignatureAlgorithm.HS256, saltKey.getBytes()).compact();

		return jwt;
	}

}
