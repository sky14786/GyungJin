package com.gj.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.MemberDTO;

public interface MemberService {
	public String findAll() throws JsonProcessingException;

	public String findOne(String email) throws JsonProcessingException;

	public boolean create(MemberDTO member);

	public boolean update(MemberDTO member);

	public boolean delete(MemberDTO member);
	
	public MemberDTO login(MemberDTO member);

}
