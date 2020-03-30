package com.gj.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.ClientDTO;
import com.gj.common.mapper.ClientMapper;

@Service
public class ClientServiceImpl implements ClientService {

	private final int TRADE_PER_PAGE = 10;

	@Autowired
	private ClientMapper clientMapper;

	@Override
	public String findAll(int page) throws JsonProcessingException {
		List<ClientDTO> temp = clientMapper.findAll();
		List<ClientDTO> resultTemp = new ArrayList<>();

		int range = temp.size() <= (page * TRADE_PER_PAGE) ? temp.size() : page * TRADE_PER_PAGE;

		for (int i = (page == 1 ? 0 : TRADE_PER_PAGE * page - TRADE_PER_PAGE); i < range; i++) {
			resultTemp.add(temp.get(i));
		}
		String result = toJson(resultTemp);
		String count = ",{\"count\" :" + temp.size() + "}]";
		result = result.replace("]", count);
		return result;
	}

	@Override
	public String search(String keyword, String type, int page) throws JsonProcessingException {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("keyword", keyword);
		parameter.put("type", type);

		List<ClientDTO> temp = clientMapper.search(parameter);
		List<ClientDTO> resultTemp = new ArrayList<>();

		int range = temp.size() <= (page * TRADE_PER_PAGE) ? temp.size() : page * TRADE_PER_PAGE;

		for (int i = (page == 1 ? 0 : TRADE_PER_PAGE * page - TRADE_PER_PAGE); i < range; i++) {
			resultTemp.add(temp.get(i));
		}
		String result = toJson(resultTemp);
		if (result.equals("[]")) {
			result = "[{\"result\":null}]";
		} else {
			String count = ",{\"count\" :" + temp.size() + "}]";
			result = result.replace("]", count);
		}
		return result;
	}

	@Override
	public boolean create(ClientDTO client) {
		return validatingCheck(client) ? (clientMapper.create(client) == 1 ? true : false) : false;
	}

	@Override
	public boolean update(ClientDTO client, int index) {
		client.setClientCode(index);
		return validatingCheck(client) ? (clientMapper.update(client) == 1 ? true : false) : false;

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
