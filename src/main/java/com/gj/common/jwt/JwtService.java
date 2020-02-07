package com.gj.common.jwt;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
	public String createToken(HttpServletRequest res);
	public boolean validateToken(String jwt)throws Exception;
}
