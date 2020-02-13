package com.gj.transaction;

import java.util.List;

import com.gj.common.dto.TransactionDTO;

public interface TransactionService {
	public List<TransactionDTO> findAll();
}
