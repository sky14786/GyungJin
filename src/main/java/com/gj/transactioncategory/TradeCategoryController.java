package com.gj.transactioncategory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TradeCategoryDTO;

@RestController
@RequestMapping("/api")
public class TradeCategoryController {
	private Log log = LogFactory.getLog(TradeCategoryController.class);

	@Autowired
	TradeCategoryService tcService;

	@GetMapping(value = "/tradeCategory")
	public String findAll() throws JsonProcessingException {
		return tcService.findAll();
	}

	@PostMapping(value = "/tradeCategory")
	public boolean insert(@RequestBody TradeCategoryDTO tradeCategory) {
		return tcService.insert(tradeCategory);
	}
}
