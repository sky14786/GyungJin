package com.gj.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.EstimateDTO;

@Mapper
public interface EstimateMapper {
	public int create(EstimateDTO estimate);

	public EstimateDTO findOne(int index);
}
