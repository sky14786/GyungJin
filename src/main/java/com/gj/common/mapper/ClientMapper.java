package com.gj.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.ClientDTO;

@Mapper
public interface ClientMapper {
	public List<ClientDTO> findAll();

	public int create(ClientDTO client);

	public int delete(String index);

	public List<ClientDTO> search(Map<String,String> parameter);

	public int update(ClientDTO client);
}
