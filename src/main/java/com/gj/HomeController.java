package com.gj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/erp")
	public String connectionErpHome() {
		return "erpindex";
	}
	
	@GetMapping("/")
	public String connectionHome() {
		return "index";
	}
}
