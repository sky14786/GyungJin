package com.gj.material;

import java.util.List;

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
import com.gj.common.dto.MaterialDTO;

@RestController
@RequestMapping("/api")
public class MaterialController {
	private Log log = LogFactory.getLog(MaterialController.class);

	@Autowired
	MaterialService materialService;

	@PostMapping("/material")
	public String create(@RequestBody List<MaterialDTO> materials) throws JsonProcessingException {
		return materialService.create(materials);

	}

	@PutMapping("/material")
	public String update(@RequestBody List<MaterialDTO> materials) throws JsonProcessingException {
		return materialService.update(materials);
	}

	@GetMapping("/material/{index}")
	public String findOne(@PathVariable(value = "index") int index) throws JsonProcessingException {
		return materialService.findOne(index);
	}
}
