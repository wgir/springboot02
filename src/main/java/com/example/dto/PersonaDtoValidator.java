package com.example.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.repository.TipoDocumentoRepository;

@Component
public class PersonaDtoValidator implements Validator {

	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;

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
		if (StringUtils.isEmpty(param.getFirstName()))
			errors.reject("100","The firstname is requerid");
		if (param.getLastName().equals("b")) 
			errors.reject("100","The lastname can't be b");
		if(tipoDocumentoRepository.findAll().stream().filter(o->o.getId()==param.getTipoDocumentoId()).count()<=0)
			errors.reject("100","El id del tipo de documento no es valido");
		 
	//}

}

}