package com.gj.clientcategory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.ClientCategoryDTO;

@RestController
@RequestMapping("/api")
public class ClientCategoryController {
	private Log log = LogFactory.getLog(ClientCategoryController.class);

	@Autowired
	private ClientCategoryService service;

	@GetMapping("/clientcategory")
	public String findAll() throws JsonProcessingException {
		return service.findAll();
	}

	@PostMapping("/clientcategory")
	public boolean create(@RequestBody ClientCategoryDTO clienctCategoryDTO) {
		return service.create(clienctCategoryDTO);
	}
}
