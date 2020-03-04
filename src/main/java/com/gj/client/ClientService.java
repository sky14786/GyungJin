package com.gj.client;

import java.util.List;

import com.gj.common.dto.ClientDTO;

public interface ClientService {
	public String findAll() throws Exception;

	public boolean create(ClientDTO client);
}
