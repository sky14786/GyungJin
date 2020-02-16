package com.gj.client;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gj.common.dto.ClientDTO;

@RestController
@RequestMapping("/api")
public class ClientController {

	private Log log = LogFactory.getLog(ClientController.class);

	@Autowired
	ClientService clientService;

	@GetMapping("/client")
	public List<ClientDTO> findAll() {
		return clientService.findAll();
	}

	@PostMapping("/client")
	public boolean create(@RequestBody ClientDTO client) {
		return clientService.create(client);
	}
}
