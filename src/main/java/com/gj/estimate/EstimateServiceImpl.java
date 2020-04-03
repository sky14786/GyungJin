package com.gj.estimate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.common.dto.EstimateDTO;
import com.gj.common.mapper.EstimateMapper;
import com.gj.common.mapper.MaterialMapper;
import com.gj.material.MaterialService;

@Service
public class EstimateServiceImpl implements EstimateService {

	@Autowired
	EstimateMapper estimateMapper;

	@Autowired
	MaterialMapper materialMapper;

	@Override
	public String create(EstimateDTO estimate) throws JsonProcessingException {
		String result = "";
		estimateMapper.create(estimate);
		result = toJson(estimate);
		return result;
	}

	@Override
	public boolean update(EstimateDTO estimate) {
		EstimateDTO temp = estimateMapper.findOne(estimate.getEstCode());
		System.out.println(temp);
		System.out.println(estimate);
		if (estimateMapper.update(estimate) == 1) {
			if (estimate.getMaterial1() != temp.getMaterial1()) {
				if (estimate.getMaterial1() == 0) {
					materialMapper.delete(temp.getMaterial1());
				}
			}
			if (estimate.getMaterial2() != temp.getMaterial2()) {
				if (estimate.getMaterial2() == 0) {
					materialMapper.delete(temp.getMaterial2());
				}
			}
			if (estimate.getMaterial3() != temp.getMaterial3()) {
				if (estimate.getMaterial3() == 0) {
					materialMapper.delete(temp.getMaterial3());
				}
			}
			if (estimate.getMaterial4() != temp.getMaterial4()) {
				if (estimate.getMaterial4() == 0) {
					materialMapper.delete(temp.getMaterial4());
				}
			}
			if (estimate.getMaterial5() != temp.getMaterial5()) {
				if (estimate.getMaterial5() == 0) {
					materialMapper.delete(temp.getMaterial5());
				}
			}
			if (estimate.getMaterial6() != temp.getMaterial6()) {
				if (estimate.getMaterial6() == 0) {
					materialMapper.delete(temp.getMaterial6());
				}
			}
			if (estimate.getMaterial7() != temp.getMaterial7()) {
				if (estimate.getMaterial7() == 0) {
					materialMapper.delete(temp.getMaterial7());
				}
			}
			if (estimate.getMaterial8() != temp.getMaterial8()) {
				if (estimate.getMaterial8() == 0) {
					materialMapper.delete(temp.getMaterial8());
				}
			}
			if (estimate.getMaterial9() != temp.getMaterial9()) {
				if (estimate.getMaterial9() == 0) {
					materialMapper.delete(temp.getMaterial9());
				}
			}
			if (estimate.getMaterial10() != temp.getMaterial10()) {
				if (estimate.getMaterial10() == 0) {
					materialMapper.delete(temp.getMaterial10());
				}
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public String findOne(int index) throws JsonProcessingException {
		EstimateDTO estimate = estimateMapper.findOne(index);
		String result = toJson(estimate);
		return result;
	}

	private String toJson(EstimateDTO temp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(temp);
		return result;
	}
}
