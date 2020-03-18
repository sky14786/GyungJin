package com.gj.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.ClientDTO;

public interface ClientService {
	public String findAll(int page) throws Exception;

	public boolean create(ClientDTO client);

	public String search(String keyword, String type, int page) throws JsonProcessingException;

	public int delete(String index);

	public boolean update(ClientDTO client, int index);
}
