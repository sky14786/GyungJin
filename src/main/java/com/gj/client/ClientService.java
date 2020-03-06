package com.gj.client;

import com.gj.common.dto.ClientDTO;

public interface ClientService {
	public String findAll() throws Exception;

	public boolean create(ClientDTO client);

	public int delete(String index);
}
