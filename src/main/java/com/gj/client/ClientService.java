package com.gj.client;

import java.util.List;

import com.gj.common.dto.ClientDTO;

public interface ClientService {
	List<ClientDTO> findAll();
}
