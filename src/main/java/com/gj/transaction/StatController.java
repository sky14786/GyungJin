package com.gj.transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class StatController {
	private Log log = LogFactory.getLog(StatController.class);

	@Autowired
	TransactionService transactionService;

	@GetMapping("/stat")
	public String findAll(@RequestParam(value = "year", defaultValue = "-1") int year,
			@RequestParam(value = "month", defaultValue = "-1") int month,
			@RequestParam(value = "page", defaultValue = "1") int page) throws JsonProcessingException {
		String result = "";
		if (year != -1 && month != -1) {
			result = transactionService.monthStat(year, month, page);
		}
		return result;
	}
}
