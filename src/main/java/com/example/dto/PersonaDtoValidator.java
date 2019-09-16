package com.example.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.repository.PersonaRepository;
import com.example.repository.TipoDocumentoRepository;

@Component
public class PersonaDtoValidator implements Validator {

	@Autowired
	PersonaRepository personaRepository;

@Override
public boolean supports(Class<?> clazz) {
return PersonaDto.class.isAssignableFrom(clazz);
}

@Override
public void validate(Object target, Errors errors) 
{
//	if (errors.getErrorCount() == 0) 
	//{
	PersonaDto param = (PersonaDto) target;
		if (StringUtils.isEmpty(param.getNombres()))
			errors.reject("100","El campo 'nombres' es requerido");
		if (StringUtils.isEmpty(param.getEmail()))
			errors.reject("100","El campo 'email' es requerido");
		if(param.getId()==0)
			if(personaRepository.findAll().stream().filter(o->o.getEmail()==param.getEmail()).count()>0)
				errors.reject("100","El correo electronico ya se encuentra registrado. Debe registrar otro correo electronico");
		 
	//}

}

}