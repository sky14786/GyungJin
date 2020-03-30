package com.gj.refresh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.dto.MemberDTO;
import com.gj.common.dto.RefreshTokenDTO;
import com.gj.common.jwt.JwtService;
import com.gj.common.mapper.RefreshTokenMapper;
import com.gj.member.MemberService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

	private final String saltKey = "JinGyung";

	@Autowired
	private RefreshTokenMapper mapper;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

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
	public String accessTokenReissuance(String refreshToken) {
		MemberDTO member = null;
		String result = "";
		if (!refreshToken.equals("") && refreshToken != null) {
			List<RefreshTokenDTO> list = mapper.selectOne(refreshToken);
			if (list.size() == 1) {
				member = memberService.findOneMemberDTO(list.get(0).getMemId());
				if (member != null) {
					result = jwtService.createToken(member);
					System.out.println(result);
				}

			}
		}
		return result;
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

	@Override
	public String validateToken(String refreshToken) throws Exception {
		try {
			Claims claims = Jwts.parser().setSigningKey(saltKey.getBytes()).parseClaimsJws(refreshToken).getBody();
			return "true";
		} catch (ExpiredJwtException exception) {
			// 토큰 시간 만료
			// log.info("Token Expiration");
			return "Expiration";
		} catch (JwtException exception) {
			// 토큰 변조
			// log.info("Token Modulation");
			return "Modulation";
		}
	}
}
