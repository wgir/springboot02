package com.example.dto.Usuario;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.entities.*;
import com.example.repository.*;

@Component
public class UsuarioDtoRegistroValidator implements Validator {

	@Autowired
	UsuarioRepository repository;
	String regex = "^(.+)@(.+)$";
	Pattern pattern = Pattern.compile(regex);
	
	@Override
	public boolean supports(Class<?> clazz) {
	return UsuarioDtoRegistro.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
	//	if (errors.getErrorCount() == 0) 
		//{
		UsuarioDtoRegistro  param = (UsuarioDtoRegistro)target;
		List<Segu_Usuario> lista=repository.findAll();
		if(lista.stream().filter(o->o.getUserName().toUpperCase().trim().equals(param.getUserName().toUpperCase().trim())).count()>0)
				errors.reject("100","Ya existe un usuario con el mismo correo");
		Matcher matcher = pattern.matcher(param.getUserName());
		if(matcher.matches()==false)
			errors.reject("100","Email no valido");
	}
}