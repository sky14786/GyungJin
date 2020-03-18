package com.gj.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gj.common.dto.ClientDTO;

@RestController
@RequestMapping("/api")
public class ClientController {

	private Log log = LogFactory.getLog(ClientController.class);

	@Autowired
	ClientService clientService;

	@GetMapping("/client")
	public String findAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "type", required = false) String type) throws Exception {
		String result = "";
		if(keyword!=null&&type!=null) {
			result = clientService.search(keyword,type,page);
		}else {
			result = clientService.findAll(page);
		}
		System.out.println(result);
		return result;
	}

	@PostMapping("/client")
	public boolean create(@RequestBody ClientDTO client) {
		return clientService.create(client);
	}

	@PutMapping("/client/{index}")
	public String update(@RequestBody ClientDTO client, @PathVariable(value = "index") int index) {
		return clientService.update(client, index) == true ? "true" : "false";
	}

	@DeleteMapping(value = "/client/{index}")
	public boolean delete(@PathVariable(value = "index") String index) {
		log.info("Delete Client Index : " + index);
		return clientService.delete(index) == 1 ? true : false;
	}
}
