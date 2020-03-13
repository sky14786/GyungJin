package com.gj.transaction;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TransactionDTO;

public interface TransactionService {
	public String findAll() throws JsonProcessingException;

	public boolean create(TransactionDTO temp);
}
