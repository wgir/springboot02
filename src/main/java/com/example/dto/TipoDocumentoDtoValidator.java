package com.example.dto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.entities.TipoDocumento;
import com.example.repository.TipoDocumentoRepository;

@Component
public class TipoDocumentoDtoValidator implements Validator {

	@Autowired
	TipoDocumentoRepository repository;

@Override
public boolean supports(Class<?> clazz) {
return TipoDocumentoDto.class.isAssignableFrom(clazz);
}

@Override
public void validate(Object target, Errors errors) 
{
//	if (errors.getErrorCount() == 0) 
	//{
	TipoDocumentoDto  param = (TipoDocumentoDto)target;
	List<TipoDocumento> lista=repository.findAll();
	if(lista.stream().filter(o->o.getGlosa().trim().equals(param.getGlosa().trim())).count()>0)
			errors.reject("100","Ya existe el mismo tipo de documento");
		
}

}