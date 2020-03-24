package com.gj.estimate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.EstimateDTO;

public interface EstimateService {
	public String create(EstimateDTO estimate) throws JsonProcessingException;

	public String findOne(int index) throws JsonProcessingException;
}
