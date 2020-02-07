package com.gj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.common.dto.ClientDTO;
import com.gj.common.mapper.ClientMapper;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientMapper clientMapper;
	
	@Override
	public List<ClientDTO> findAll() {
		return clientMapper.findAll();
	}
	
}
