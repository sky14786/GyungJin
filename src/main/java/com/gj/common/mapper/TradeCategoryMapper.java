package com.gj.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.TradeCategoryDTO;

@Mapper
public interface TradeCategoryMapper {
	public List<TradeCategoryDTO> findAll();
}
