package com.gj.material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.MaterialDTO;
import com.gj.common.mapper.MaterialMapper;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialMapper materialMapper;

	@Override
	public String create(List<MaterialDTO> materials) throws JsonProcessingException {
		for (int i = 0; i < materials.size(); i++) {
			materialMapper.create(materials.get(i));
		}
		return toJson(materials);
	}

	@Override
	public String findOne(int index) throws JsonProcessingException {
		MaterialDTO material = materialMapper.findOne(index);
		return toJson(material);
	}

	private String toJson(List<MaterialDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private String toJson(MaterialDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
