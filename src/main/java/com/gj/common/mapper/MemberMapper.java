package com.gj.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	public List<MemberDTO> findAll();

	public MemberDTO findOne(String email);

	public int create(MemberDTO member);

	public int update(MemberDTO member);

	public int delete(MemberDTO member);
	
	public MemberDTO login(MemberDTO member);
}
