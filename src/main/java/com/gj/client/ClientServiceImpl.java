package com.gj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.ClientDTO;
import com.gj.common.mapper.ClientMapper;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientMapper clientMapper;

	@Override
	public String findAll() throws JsonProcessingException {
		String result = toJson(clientMapper.findAll());
		return result;
	}

	@Override
	public boolean create(ClientDTO client) {
		return validatingCheck(client) ? (clientMapper.create(client) == 1 ? true : false) : false;
	}

	@Override
	public int delete(String index) {
		int isDelete = -1;
		if (index != null && !index.equals("")) {
			isDelete = clientMapper.delete(index);
		}
		return isDelete;
	}

	private boolean validatingCheck(ClientDTO client) {
		if (client.getClientCustomer() == null || client.getClientCustomer().equals("")) {
			return false;
		}
		if (client.getClientName() == null || client.getClientName().equals("")) {
			return false;
		}
		if (client.getClientTel() == null || client.getClientTel().equals("")) {
			return false;
		}
		if (client.getClientCategory() < 0) {
			return false;
		}
		if (client.getUpdUser() == null || client.getUpdUser().equals("")) {
			client.setUpdUser("010-6332-3652");
		}
		return true;
	}

	private String toJson(List<ClientDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

}
