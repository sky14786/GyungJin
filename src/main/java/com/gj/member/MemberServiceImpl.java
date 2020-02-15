package com.gj.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.SHA512Encryption;
import com.gj.common.dto.MemberDTO;
import com.gj.common.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberDTO> findAll() {
		return memberMapper.findAll();
	}

	@Override
	public boolean create(MemberDTO member) {
		member = updUserValidate(member);
		boolean isComplete = false;
		if (member != null) {
			SHA512Encryption encoder = new SHA512Encryption();
			member.setMemPwd(encoder.encryption(member.getMemPwd()));
			if(!member.getMemPwd().equals("")) {
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

}
