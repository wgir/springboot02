package com.example.dto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.entities.Contacto;
import com.example.repository.ContactoRepository;

@Component
public class ContactoDtoValidator implements Validator {

	@Autowired
	ContactoRepository contactoRepository;

@Override
public boolean supports(Class<?> clazz) {
return Contacto.class.isAssignableFrom(clazz);
}

@Override
public void validate(Object target, Errors errors) 
{
//	if (errors.getErrorCount() == 0) 
	//{
	ContactoDto  param = (ContactoDto)target;
	List<Contacto> lista=contactoRepository.findAll();
	//.stream().filter(o->o.getDocumento().trim()==param.getDocumento().trim()).findAny();
	if(lista.stream().filter(o->o.getDocumento().trim().equals(param.getDocumento().trim())).count()>0)
			errors.reject("100","Ya existe un contacto con el mismo numero de documento");
		 
	//}

}

}