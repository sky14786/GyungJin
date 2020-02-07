package com.gj.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gj.common.dto.ClientDTO;

@Mapper
public interface ClientMapper {
	List<ClientDTO> findAll();
}
