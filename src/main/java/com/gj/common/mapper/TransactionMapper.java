package com.gj.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.TransactionDTO;

@Mapper
public interface TransactionMapper {
	public List<TransactionDTO> findAll();

	public TransactionDTO findOne(int index);

	public int delete(int index);

	public int create(TransactionDTO temp);

	public int update(TransactionDTO temp);

	public List<TransactionDTO> search(Map<String, String> parameter);

	public Map<String, Integer> monthStat(String parameter);

	public List<TransactionDTO> dateSearch(String parameter);
}
