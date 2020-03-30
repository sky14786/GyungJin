package com.gj.refresh;

import java.util.List;

import com.gj.common.dto.MemberDTO;
import com.gj.common.dto.RefreshTokenDTO;

public interface RefreshTokenService {
	public String create(MemberDTO temp);

	public List<RefreshTokenDTO> select(MemberDTO temp);

	public String refreshOne(MemberDTO temp);

	public String accessTokenReissuance(String refreshToken);

	public String validateToken(String refreshToken) throws Exception;
}
