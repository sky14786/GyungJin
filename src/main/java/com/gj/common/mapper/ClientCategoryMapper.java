package com.gj.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.ClientCategoryDTO;

@Mapper
public interface ClientCategoryMapper {
	public List<ClientCategoryDTO> findAll();
	
}
