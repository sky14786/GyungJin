package com.gj.clientcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.UTCMapper;
import com.gj.common.dto.ClientCategoryDTO;
import com.gj.common.dto.MemberDTO;
import com.gj.common.mapper.ClientCategoryMapper;

@Service
public class ClientCategoryServiceImpl implements ClientCategoryService {
	@Autowired
	private ClientCategoryMapper mapper;

	@Override
	public String findAll() throws JsonProcessingException {
		String result = toJson(mapper.findAll());
		return result;
	}

	@Override
	public boolean create(ClientCategoryDTO clientCategoryDTO) {
		List<ClientCategoryDTO> list = mapper.findAll();
		for(int i = 0 ; i<list.size();i++) {
			if(list.get(i).getClientCateName().equals(clientCategoryDTO.getClientCateName())) {
				return false;
			}
		}
		return validatingCheck(clientCategoryDTO) ? (mapper.create(clientCategoryDTO) == 1 ? true : false) : false;
	}

	private String toJson(List<ClientCategoryDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private boolean validatingCheck(ClientCategoryDTO clientCategoryDTO) {
		if (clientCategoryDTO.getClientCateName() == null || clientCategoryDTO.getClientCateName().equals("")) {
			return false;
		}
		return true;
	}

}
