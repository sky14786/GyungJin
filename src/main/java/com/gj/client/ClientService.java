package com.gj.client;

import java.util.List;

import com.gj.common.dto.ClientDTO;

public interface ClientService {
	public List<ClientDTO> findAll();

	public boolean create(ClientDTO client);
}
