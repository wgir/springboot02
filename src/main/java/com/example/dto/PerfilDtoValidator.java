package com.example.dto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.entities.*;
import com.example.repository.*;

@Component
public class PerfilDtoValidator implements Validator {

	@Autowired
	PerfilRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
	return PerfilDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
	//	if (errors.getErrorCount() == 0) 
		//{
		PerfilDto  param = (PerfilDto)target;
		List<Segu_Perfil> lista=repository.findAll();
		if(param.getId()==0)
			if(lista.stream().filter(o->o.getGlosa().trim().equals(param.getGlosa().trim())).count()>0)
				errors.reject("100","Ya existe el mismo perfil");
			
	}

}