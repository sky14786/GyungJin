package com.gj.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.dto.TransactionDTO;
import com.gj.common.mapper.TransactionMapper;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionMapper transactionMapper;
	@Override
	public List<TransactionDTO> findAll() {
		return transactionMapper.findAll();
	}
}
