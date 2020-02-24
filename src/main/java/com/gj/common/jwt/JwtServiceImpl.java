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
		Long expiredTime = 1000 * 60l * 15l;
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);

		payloads.put("memId", member.getMemId());
		payloads.put("type", member.getMemType());

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
			// 토큰 시간 만료
			log.info("Token Expiration");
			return false;
		} catch (JwtException exception) {
			// 토큰 변조
			log.info("Token Modulation");
			return false;
		}

	}

	@Override
	public String refreshToken() {
		Long expiredTime = 1000 * 60l * 60l * 24l * 7l;
//		Long expiredTime = 1000 * 60l;
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);
		String result = Jwts.builder().setExpiration(now).compact();
		return result;
	}

}
