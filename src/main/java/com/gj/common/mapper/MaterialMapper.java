package com.gj.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.MaterialDTO;

@Mapper
public interface MaterialMapper {
	public int create(MaterialDTO materials);

	public MaterialDTO findOne(int index);
}
