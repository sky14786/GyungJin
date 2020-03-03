package com.gj.common.jwt;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.MemberDTO;
import com.gj.member.MemberService;
import com.gj.refresh.RefreshTokenService;

@RestController
public class JwtController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@PostMapping("/oauth")
	public String createToken(@RequestBody HashMap<String, String> map) throws Exception {
		MemberDTO member = null;

		String memId = map.get("memId");
		String memPwd = map.get("memPwd");

		if (!memId.equals("") && !memPwd.equals("")) {
			member = new MemberDTO();
			member.setMemId(memId);
			member.setMemPwd(memPwd);
		}

		member = memberService.login(member);
		String result = null;
		if (member != null) {
			result = jwtService.createToken(member);
			map.clear();
			map.put("accessToken", result);
			if (refreshTokenService.select(member).size() != 0) {
				map.put("refreshToken", refreshTokenService.refreshOne(member));
			} else {
				map.put("refreshToken", refreshTokenService.create(member));
			}
			result = toJson(map);
		}
		return result;
	}

	@GetMapping("/oauth")
	public String validateToken(HttpServletRequest res) throws Exception {
		Cookie[] cookies = res.getCookies();
		String result = "";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("accessToken")) {
				// 토큰 만료
				if (jwtService.validateToken(cookies[i].getValue()).equals("Expiration")) {
					if (cookies[i + 1].getName().equals("refreshToken")) {
						String refreshToken = cookies[i + 1].getValue();
						if (refreshTokenService.validateToken(refreshToken).equals("true")) {
							result = refreshTokenService.accessTokenReissuance(refreshToken);
							System.out.println(result);
							return result;
						}
					}
				}
				// 토큰 변조
				if (jwtService.validateToken(cookies[i].getValue()).equals("Modulation")) {
					return "Modulation";
				}
			}
		}
		return "false";
	}

	private String toJson(HashMap<String, String> map) throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		String result = ob.writeValueAsString(map);
		return result;
	}
}
