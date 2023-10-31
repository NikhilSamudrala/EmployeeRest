package com.employee.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;

public class EmployeeMapper {
	
	@Autowired
	private static ModelMapper modelMapper;

	public static EmployeeDTO convertToEmployeeDTO(EmployeeEntity employee) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	public static  EmployeeEntity convertToEmployeeEntity(EmployeeDTO employee) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(employee, EmployeeEntity.class);
	}
}
