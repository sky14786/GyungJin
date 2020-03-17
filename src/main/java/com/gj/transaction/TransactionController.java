package com.gj.transaction;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gj.common.dto.TransactionDTO;

@RequestMapping("/api")
@RestController
public class TransactionController {

	private Log log = LogFactory.getLog(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@GetMapping("/transaction")
	public String findAll(@RequestParam("page") int page) throws JsonProcessingException {
		return transactionService.findAll(page);
	}

	@GetMapping("/transaction/{index}")
	public String findOne(@PathVariable(value = "index") int index) throws JsonProcessingException {
		return transactionService.findOne(index);
	}

	@PostMapping("/transaction")
	public Boolean insert(@RequestBody TransactionDTO transaction) {
		return transactionService.create(transaction);
	}

	@DeleteMapping("/transaction/{index}")
	public boolean delete(@PathVariable(value = "index") int index) {
		log.info("Delete Transaction Index : " + index);
		return transactionService.delete(index);
	}

	@PutMapping("/transaction/{index}")
	public String update(@RequestBody TransactionDTO transaction, @PathVariable(value = "index") int index) {
		return transactionService.update(transaction, index) == true ? "true" : "false";
	}

}
