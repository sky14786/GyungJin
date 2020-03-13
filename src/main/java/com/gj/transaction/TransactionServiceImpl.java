package com.gj.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.MemberDTO;
import com.gj.common.dto.TransactionDTO;
import com.gj.common.mapper.TransactionMapper;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionMapper transactionMapper;

	@Override
	public String findAll() throws JsonProcessingException {
		String result = toJson(transactionMapper.findAll());
		return result;
	}

	@Override
	public boolean create(TransactionDTO temp) {
		temp.setUpdUser("rlawjdejr71@naver.com");
		return transactionMapper.create(temp) == 1 ? true : false;
	}

	private String toJson(List<TransactionDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private String toJson(TransactionDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
