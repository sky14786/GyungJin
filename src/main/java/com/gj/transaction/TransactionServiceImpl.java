package com.gj.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.TransactionDTO;
import com.gj.common.mapper.TransactionMapper;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final int TRADE_PER_PAGE = 10;

	@Autowired
	TransactionMapper transactionMapper;

	@Override
	public String findAll(int page) throws JsonProcessingException {
		List<TransactionDTO> temp = transactionMapper.findAll();
		List<TransactionDTO> resultTemp = new ArrayList<>();

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

		List<TransactionDTO> temp = transactionMapper.search(parameter);
		List<TransactionDTO> resultTemp = new ArrayList<>();

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
	public String findOne(int index) throws JsonProcessingException {
		String result = toJson(transactionMapper.findOne(index));
		return result;
	}

	@Override
	public boolean update(TransactionDTO transaction, int index) {
		transaction.setTraCode(index);
		return transactionMapper.update(transaction) == 1 ? true : false;
	}

	@Override
	public boolean create(TransactionDTO temp) {
		temp.setUpdUser("rlawjdejr71@naver.com");
		return transactionMapper.create(temp) == 1 ? true : false;
	}

	@Override
	public String monthStat(int year, String month, int page) throws JsonProcessingException {
		String parameter = year+"-"+ month;
		Map<String, Integer> temp = transactionMapper.monthStat(parameter);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";

		List<TransactionDTO> tempList = transactionMapper.dateSearch(parameter);
		List<TransactionDTO> resultTemp = new ArrayList<>();

		int range = tempList.size() <= (page * TRADE_PER_PAGE) ? tempList.size() : page * TRADE_PER_PAGE;

		for (int i = (page == 1 ? 0 : TRADE_PER_PAGE * page - TRADE_PER_PAGE); i < range; i++) {
			resultTemp.add(tempList.get(i));
		}

		result = toJson(resultTemp);

		if (result.equals("[]")) {
			result = "[{\"result\":null}]";
		} else {
			String count = ",{\"count\" :" + tempList.size() + "}]";
			result = result.replace("]", "," + mapper.writeValueAsString(temp) + count);
		}

		return result;
	}

	@Override
	public boolean delete(int index) {
		return transactionMapper.delete(index) == 1 ? true : false;
	}

	private String toJson(List<TransactionDTO> temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

	private String toJson(TransactionDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}

}
