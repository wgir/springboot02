package com.example.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto._DTOEntity;

@Component
public class Mapeo{

	@Autowired
	private ModelMapper modelMapper;
	
	
		 
	public _DTOEntity convertToDto(Object obj, _DTOEntity dto) {
	    return modelMapper.map(obj, dto.getClass());
	  }
	 
	  public Object convertToEntity(_DTOEntity dto,Object obj ) {
	    return modelMapper.map(dto, obj.getClass());
	  }
}
