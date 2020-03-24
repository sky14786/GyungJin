package com.gj.estimate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.EstimateDTO;
import com.gj.common.mapper.EstimateMapper;

@Service
public class EstimateServiceImpl implements EstimateService {

	@Autowired
	EstimateMapper estimateMapper;

	@Override
	public String create(EstimateDTO estimate) throws JsonProcessingException {
		String result = "";
		estimateMapper.create(estimate);
		result = toJson(estimate);
		return result;
	}

	@Override
	public String findOne(int index) throws JsonProcessingException {
		EstimateDTO estimate = estimateMapper.findOne(index);
		String result = toJson(estimate);
		return result;
	}

	private String toJson(EstimateDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
