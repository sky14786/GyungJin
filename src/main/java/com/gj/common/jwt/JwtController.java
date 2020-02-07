package com.gj.common.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
	@Autowired
	private JwtService jwtService;

	@PostMapping("/jwt")
	public String createToken(HttpServletRequest res) throws Exception {
		return jwtService.createToken(res);
	}

	@GetMapping("/jwt")
	public boolean validateToken(HttpServletRequest res) throws Exception {
		String jwt = res.getParameter("jwt");

		if (jwt != null) {
			return jwtService.validateToken(jwt);
		} else {
			return false;
		}
	}
}
