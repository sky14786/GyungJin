package com.gj.transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TransactionDTO;

public interface TransactionService {
	public String findAll(int page) throws JsonProcessingException;

	public boolean create(TransactionDTO temp);

	public String findOne(int index) throws JsonProcessingException;

	public boolean delete(int index);

	public String search(String keyword, String type, int page) throws JsonProcessingException;

	public boolean update(TransactionDTO transaction, int index);
}
