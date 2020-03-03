package com.gj.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.MemberDTO;
import com.gj.common.dto.RefreshTokenDTO;

@Mapper
public interface RefreshTokenMapper {
	public int create(RefreshTokenDTO temp);

	public List<RefreshTokenDTO> select(MemberDTO temp);

	public int refreshOne(RefreshTokenDTO temp);

	public List<RefreshTokenDTO> selectOne(String refreshToken);
}
