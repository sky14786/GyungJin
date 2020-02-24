package com.gj.member;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.SHA512Encryption;
import com.gj.common.UTCMapper;
import com.gj.common.dto.ClientCategoryDTO;
import com.gj.common.dto.MemberDTO;
import com.gj.common.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public String findAll() throws JsonProcessingException {
		String result = toJson(memberMapper.findAll());
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		MemberDTO result = null;
		if (!member.getMemId().equals("") && !member.getMemPwd().equals("")) {
			SHA512Encryption encoder = new SHA512Encryption();
			member.setMemPwd(encoder.encryption(member.getMemPwd(), "password"));
			result = memberMapper.login(member);
		}
		return result;
	}

	@Override
	public String findOne(String email) throws JsonProcessingException {
		String result = "";
		if (email != null && !email.equals("")) {
			MemberDTO member = memberMapper.findOne(email);
			member = timeSet(member);
			result = toJson(member);
		}
		return result;
	}

	@Override
	public boolean create(MemberDTO member) {
		member = updUserValidate(member);
		boolean isComplete = false;
		if (member != null) {
			SHA512Encryption encoder = new SHA512Encryption();
			member.setMemPwd(encoder.encryption(member.getMemPwd(), "password"));
			if (!member.getMemPwd().equals("")) {
				isComplete = memberMapper.create(member) == 1 ? true : false;
			}
		}
		return isComplete;
	}

	@Override
	public boolean update(MemberDTO member) {
		member = updUserValidate(member);
		boolean isComplete = false;
		if (member != null) {
			isComplete = memberMapper.update(member) == 1 ? true : false;
		}
		return isComplete;
	}

	@Override
	public boolean delete(MemberDTO member) {
		member = updUserValidate(member);
		boolean isComplete = false;
		if (member != null) {
			isComplete = memberMapper.delete(member) == 1 ? true : false;
		}
		return isComplete;
	}

	private MemberDTO updUserValidate(MemberDTO member) {
		boolean isValidate = false;
		if (!member.getMemId().equals("")) {
			if (member.getUpdUser().equals("")) {
				member.setUpdUser(member.getMemName());
				isValidate = true;
			}
		}
		return isValidate ? member : null;
	}

	private String toJson(List<MemberDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private String toJson(MemberDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private MemberDTO timeSet(MemberDTO temp) {
		temp.setRegDate(UTCMapper.toKor(temp.getRegDate()));
		temp.setUpdDate(UTCMapper.toKor(temp.getUpdDate()));
		return temp;
	}

}
