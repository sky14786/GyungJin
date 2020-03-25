package com.gj.material;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.MaterialDTO;

public interface MaterialService {
	public String create(List<MaterialDTO> materials) throws JsonProcessingException;

	public String update(List<MaterialDTO> materials) throws JsonProcessingException;

	public String findOne(int index) throws JsonProcessingException;

	public boolean delete(int index);
}
