package com.gj.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gj.common.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> findAll();
	public boolean create(MemberDTO member);
	public boolean update(MemberDTO member);
	public boolean delete(MemberDTO member);
	
	
}
