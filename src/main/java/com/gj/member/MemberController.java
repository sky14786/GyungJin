package com.gj.member;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.MemberDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MemberController {

	private Log log = LogFactory.getLog(MemberController.class);

	@Autowired
	MemberService memberService;

	@GetMapping(value = "/member")
	public String findAll() throws JsonProcessingException {
		return memberService.findAll();
	}

	@GetMapping(value = "/member/{email}")
	public String findOne(@PathVariable(value = "email") String email) throws JsonProcessingException {
		return memberService.findOne(email);
	}

	@PostMapping(value = "/member")
	public boolean create(@RequestBody MemberDTO member) {
		return memberService.create(member);
	}

	@PutMapping(value = "/member")
	public boolean update(@RequestBody MemberDTO member) {
		return memberService.update(member);
	}

	@DeleteMapping(value = "/member")
	public boolean delete(@RequestBody MemberDTO member) {
		return memberService.delete(member);
	}

}
