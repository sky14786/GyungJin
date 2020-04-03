package com.gj.transactioncategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.TradeCategoryDTO;
import com.gj.common.mapper.TradeCategoryMapper;

@Service
public class TradeCategoryServiceImpl implements TradeCategoryService {

	@Autowired
	TradeCategoryMapper tcMapper;

	@Override
	public String findAll() throws JsonProcessingException {
		String result = toJson(tcMapper.findAll());
		return result;
	}

	@Override
	public boolean insert(TradeCategoryDTO tradeCategory) {
		List<TradeCategoryDTO> list = tcMapper.findAll();
		for(int i = 0 ; i <list.size();i++) {
			if(list.get(i).getTradeName().equals(tradeCategory.getTradeName())) {
				return false;
			}
		}
		return tcMapper.insert(tradeCategory) == 1 ? true : false;
	}

	private String toJson(List<TradeCategoryDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private String toJson(TradeCategoryDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
