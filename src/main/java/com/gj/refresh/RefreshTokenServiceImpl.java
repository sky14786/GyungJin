package com.gj.refresh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.SHA512Encryption;
import com.gj.common.dto.MemberDTO;
import com.gj.common.dto.RefreshTokenDTO;
import com.gj.common.jwt.JwtService;
import com.gj.common.mapper.RefreshTokenMapper;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
	@Autowired
	private RefreshTokenMapper mapper;

	@Autowired
	private JwtService jwtService;

	@Override
	public String create(MemberDTO temp) {
		int result = 0;
		RefreshTokenDTO tokenDTO = new RefreshTokenDTO();
		if (!temp.getMemId().equals("") && temp.getMemId() != null) {
			tokenDTO.setMemId(temp.getMemId());
			String token = "";
			token = jwtService.refreshToken();
//			token = encoder.encryption(tokenDTO.getMemId(), "refresh");
			tokenDTO.setMemReToken(token);
			result = mapper.create(tokenDTO);
		}

		return result == 1 ? tokenDTO.getMemReToken() : "";
	}

	@Override
	public List<RefreshTokenDTO> select(MemberDTO temp) {
		List<RefreshTokenDTO> token = new ArrayList<>();
		if (!temp.getMemId().equals("") && temp.getMemId() != null) {
			token = mapper.select(temp);
		}
		return token;
	}

	@Override
	public String refreshOne(MemberDTO temp) {
		int result = 0;
		RefreshTokenDTO tokenDTO = new RefreshTokenDTO();
		if (!temp.getMemId().equals("") && temp.getMemId() != null) {
			tokenDTO.setMemId(temp.getMemId());
			String token = "";
			token = jwtService.refreshToken();
//			token = encoder.encryption(tokenDTO.getMemId(), "refresh");
			tokenDTO.setMemReToken(token);
			result = mapper.refreshOne(tokenDTO);
		}

		return result == 1 ? tokenDTO.getMemReToken() : "";
	}

}
