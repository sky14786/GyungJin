package com.gj.common.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gj.common.dto.MemberDTO;
import com.gj.member.MemberService;

@RestController
public class JwtController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

	@PostMapping("/jwt")
	public String createToken(HttpServletRequest res) throws Exception {
		MemberDTO member = null;
		String memId = res.getParameter("memId");
		String memPwd = res.getParameter("memPwd");
		
		if(!memId.equals("") && !memPwd.equals("")) {
			member = new MemberDTO();
			member.setMemId(memId);
			member.setMemPwd(memPwd);
		}
		
		member = memberService.login(member);
		String result = null;
		if(member != null) {
			result = jwtService.createToken(member.getMemId());
		}
		
		return result;
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
