package com.gj.common.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> findAll();
	int create(MemberDTO member);
	int update(MemberDTO member);
	int delete(MemberDTO member);
}
