package com.gj.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.dto.MemberDTO;
import com.gj.common.mapper.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<HashMap<String, Object>> findAlltest() {
		return memberMapper.findAlltest();
	}

	@Override
	public int create(HashMap map) {
		map.put("updUser", map.get("memId"));
		map.put("updDate", "DEFAULT");
		System.out.println(map);
		return memberMapper.create(map);
	}
	
	@Override
	public List<MemberDTO> findAll() {
		return memberMapper.findAll();
	}
}
