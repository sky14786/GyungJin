package com.gj.transactioncategory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TradeCategoryDTO;

public interface TradeCategoryService {
	public String findAll() throws JsonProcessingException;

	public boolean insert(TradeCategoryDTO tradeCategory);
}
