package com.gj.common;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {
	public String toJson(ArrayList<Object> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
