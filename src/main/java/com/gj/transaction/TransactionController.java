package com.gj.transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TransactionDTO;

@RequestMapping("/api")
@RestController
public class TransactionController {

	private Log log = LogFactory.getLog(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@GetMapping("/transaction")
	public String findAll() throws JsonProcessingException {
		return transactionService.findAll();
	}

	@PostMapping("/transaction")
	public Boolean insert(@RequestBody TransactionDTO transaction) {
		return transactionService.create(transaction);
	}

}
