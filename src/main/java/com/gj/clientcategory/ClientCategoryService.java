package com.gj.clientcategory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.ClientCategoryDTO;

public interface ClientCategoryService {
	public String findAll() throws JsonProcessingException;

	public boolean create(ClientCategoryDTO clientCategoryDTO);
}
