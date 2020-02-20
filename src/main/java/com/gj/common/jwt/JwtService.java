package com.gj.common.jwt;

import com.gj.common.dto.MemberDTO;

public interface JwtService {
	public String createToken(MemberDTO member);
	public boolean validateToken(String jwt)throws Exception;
}
