package com.gj.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gj.common.dto.TransactionDTO;
@RequestMapping("/api")
@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transaction")
	public List<TransactionDTO> findAll(){
		return transactionService.findAll();
	}
	
}
