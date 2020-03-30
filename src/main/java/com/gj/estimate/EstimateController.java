package com.gj.estimate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.EstimateDTO;

@RestController
@RequestMapping("/api")
public class EstimateController {
	private Log log = LogFactory.getLog(EstimateController.class);

	@Autowired
	private EstimateService estimateService;

	@PostMapping("/estimate")
	public String create(@RequestBody EstimateDTO estimate) throws JsonProcessingException {
		String result = estimateService.create(estimate);
		return result;
	}

	@PutMapping("/estimate")
	public boolean update(@RequestBody EstimateDTO estimate) throws JsonProcessingException {
		return estimateService.update(estimate);
	}

	@GetMapping("/estimate/{index}")
	public String findOne(@PathVariable(value = "index") int index) throws JsonProcessingException {
		return estimateService.findOne(index);
	}
}
